package stark.db.csvtosql;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CsvToSql {

	public static void main(String[] args) throws IOException, FileNotFoundException {
		String table = getTable();
		FileReader fileReader = new FileReader("D:/Workspace/Java/202209/csvtosql/db/" + table + ".csv");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		System.out.println(getInsertSqlRequest(bufferedReader, table));
		bufferedReader.close();
	}

	public static String getInsertSqlRequest(BufferedReader bufferedReader, String table) {
		String sqlReq = "INSERT INTO " + table + " (";
		ArrayList<String> al = getTableValues();
		for (int i = 0; i < al.size(); i++) {
			sqlReq += "'" + al.get(i) + "'";
			if(i < al.size() - 1) {
				sqlReq += ", ";
			}
		}
		sqlReq += ") VALUES \n";
		
		try {
			String line = bufferedReader.readLine();
			while (line != null) {
				String[] values = line.split(";");
				if (sqlReq.charAt(sqlReq.length() - 1) == ')') {
					sqlReq += ",\n";
				}
				sqlReq += "('";
				for(int i=0; i<values.length; i++) {
					if(i>0) {
						sqlReq += "','";
					}
					String value = values[i].replace("'", "’");
					sqlReq += value;
				}
				sqlReq += "')";
				line = bufferedReader.readLine();
			}
			sqlReq += ";";
		} catch (IOException e) {
			e.printStackTrace();
		}

		return sqlReq;
	}
	
	public static String getTable() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Table name :");
		String s = sc.next();
		sc.close();
		return s;
	}
	
	public static ArrayList<String> getTableValues() {
		//TODO ne propose pas de resaisir une valeur
		ArrayList<String> al = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		System.out.println("How many values ?");
		int n = 0;
		if(sc.hasNextInt()) {
			sc.nextInt();
		} else {
			System.out.println("No values");
		}
		System.out.println("Table values :");
		for(int i = 0; i < n; i++) {
			al.add(sc.next());
		}
		sc.close();
		return al;
	}
}
