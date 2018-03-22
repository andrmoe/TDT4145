package app.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBStatements {
	
	//forhåndslagde statements som tar inn variabler fra guiet og returnerer info fra database
		
		private static String nullIfNegOne(int n) {
			return n == -1 ? "NULL" : n+"";
		}
		
		private static String convertDate(String date) {
			String[] d = date.split("\\.");
			return d[2]+"-"+d[1]+"-"+d[0];
		}
		
		public static String newSession(String date, int form, int prestasjon, String note) {
			date = convertDate(date);
			return "INSERT INTO Treningsøkt (Dato, Form, Prestasjon, Notat) VALUES (\""+date+"\","+nullIfNegOne(form)+","+nullIfNegOne(prestasjon)+",\""+note+"\");";
		}
		
		public static String newExercise(String name, String description, int apparatId) {
			return "INSERT INTO Øvelse (Navn, Beskrivelse, ApparatId) VALUES (\""+name+"\",\""+description+"\","+nullIfNegOne(apparatId)+");";
		}
		
		public static String newGroup(String name) {
			return "INSERT INTO Øvelsesgruppe (Navn) VALUES (\""+name+"\");";
		}
		
		public static String newApparat(String name, String description) {
			return "INSERT INTO Apparat (Navn, Beskrivelse) VALUES (\""+name+"\",\""+description+"\");";
		}
		
		public static String addExerciseToSession(int sessionId, int exerciseId, int numberOfKilos, int numberOfSets) {
			return "INSERT INTO Utfører VALUES ("+sessionId+","+exerciseId+","+nullIfNegOne(numberOfKilos)+","+nullIfNegOne(numberOfSets)+");";
		}
		
		public static String addExerciseToGroup(int exerciseId, int groupId) {
			return "INSERT INTO Tilhører ("+exerciseId+","+groupId+");";
		}
		
		public static String getPastSessions() {
			return "SELECT Dato, Form, Prestasjon, Notat FROM Treningsøkt ORDER BY Dato DESC;";
		}
		
		public static String getPastExercises(int exerciseId, String startDate, String endDate) {
			startDate = convertDate(startDate);
			endDate = convertDate(endDate);
			return "SELECT Treningsøkt.Dato, Tilhører.AntallKilo, Tilhører.AntallSett, Treningsøkt.Notat, " + 
					"Treningsøkt.Form, Treningsøkt.Prestasjon FROM Utfører JOIN Treningsøkt ON Utfører.ØktID = Treningsøkt.ØktID " +
					"WHERE Utfører.ØvelseID = "+exerciseId+" AND Treningsøkt.Dato >= "+startDate+" AND Treningsøkt.Dato <= "+endDate+";";
		}
		
		public static String getExercisesInGroup(int groupId) {
			return "SELECT Øvelse.Navn, Beskrivelse FROM Øvelse JOIN Tilhører ON Øvelse.ØvelseID = Tilhører.ØvelseID WHERE GruppeID = "+groupId+";";
		}
		
		
}

