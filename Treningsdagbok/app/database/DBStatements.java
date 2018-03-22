package app.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBStatements {
	
	//forh�ndslagde statements som tar inn variabler fra guiet og returnerer info fra database
		
		private static String nullIfNegOne(int n) {
			return n == -1 ? "NULL" : n+"";
		}
		
		private static String convertDate(String date) {
			String[] d = date.split("\\.");
			return d[2]+"-"+d[1]+"-"+d[0];
		}
		
		public static String newSession(String date, int form, int prestasjon, String note) {
			date = convertDate(date);
			return "INSERT INTO Trenings�kt (Dato, Form, Prestasjon, Notat) VALUES (\""+date+"\","+nullIfNegOne(form)+","+nullIfNegOne(prestasjon)+",\""+note+"\");";
		}
		
		public static String newExercise(String name, String description, int apparatId) {
			return "INSERT INTO �velse (Navn, Beskrivelse, ApparatId) VALUES (\""+name+"\",\""+description+"\","+nullIfNegOne(apparatId)+");";
		}
		
		public static String newGroup(String name) {
			return "INSERT INTO �velsesgruppe (Navn) VALUES (\""+name+"\");";
		}
		
		public static String newApparat(String name, String description) {
			return "INSERT INTO Apparat (Navn, Beskrivelse) VALUES (\""+name+"\",\""+description+"\");";
		}
		
		public static String addExerciseToSession(int sessionId, int exerciseId, int numberOfKilos, int numberOfSets) {
			return "INSERT INTO Utf�rer VALUES ("+sessionId+","+exerciseId+","+nullIfNegOne(numberOfKilos)+","+nullIfNegOne(numberOfSets)+");";
		}
		
		public static String addExerciseToGroup(int exerciseId, int groupId) {
			return "INSERT INTO Tilh�rer ("+exerciseId+","+groupId+");";
		}
		
		public static String getPastSessions() {
			return "SELECT Dato, Form, Prestasjon, Notat FROM Trenings�kt ORDER BY Dato DESC;";
		}
		
		public static String getPastExercises(int exerciseId, String startDate, String endDate) {
			startDate = convertDate(startDate);
			endDate = convertDate(endDate);
			return "SELECT Trenings�kt.Dato, Tilh�rer.AntallKilo, Tilh�rer.AntallSett, Trenings�kt.Notat, " + 
					"Trenings�kt.Form, Trenings�kt.Prestasjon FROM Utf�rer JOIN Trenings�kt ON Utf�rer.�ktID = Trenings�kt.�ktID " +
					"WHERE Utf�rer.�velseID = "+exerciseId+" AND Trenings�kt.Dato >= "+startDate+" AND Trenings�kt.Dato <= "+endDate+";";
		}
		
		public static String getExercisesInGroup(int groupId) {
			return "SELECT �velse.Navn, Beskrivelse FROM �velse JOIN Tilh�rer ON �velse.�velseID = Tilh�rer.�velseID WHERE GruppeID = "+groupId+";";
		}
		
		
}

