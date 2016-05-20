package com.team3.parser;

import com.team3.models.Gender;
import com.team3.models.Movement;
import com.team3.models.Patient;
import com.team3.models.Ward;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {
	public List<Patient> patients;
	public List<Ward> wards;
	public List<Movement> moves;

	public CSVParser(){
		String patient_filename="./Data/patients.csv";
		String wards_filename = "./Data/wards.csv";
		String moves_filename = "./Data/movements.csv";
		try {
			this.parsePatient(patient_filename);
			this.parseWards(wards_filename);
			this.parseMovements(moves_filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void parsePatient(String filename) throws IOException {
		patients = new ArrayList<Patient>();
		Path path = Paths.get(filename);
		BufferedReader br = Files.newBufferedReader(path);
		String line=br.readLine();
		line=br.readLine();
		while (line != null) {

			//System.out.println(line);
			String[] s = line.split(",");
			//for (String t : s)
			//System.out.println(t);
			String date = s[2];
			String[] d = date.split("/");
			LocalDateTime dt = LocalDateTime.of(Integer.parseInt(d[2]), Integer.parseInt(d[1]), Integer.parseInt(d[0]), 0, 0);
			//System.out.println(dt);
			int id = Integer.parseInt(s[0]);
			Gender g = Gender.fromInt(Integer.parseInt(s[3]));
			Patient p = new Patient(id, s[1], dt, g);
			patients.add(p);
			line=br.readLine();
		}

	}
	
	public void parseWards(String filename) throws IOException {
		wards = new ArrayList<Ward>();
		Path path = Paths.get(filename);
		BufferedReader br = Files.newBufferedReader(path);
		String line=br.readLine();
		line = br.readLine();
		while (line != null) {
			String[] s = line.split(",");
			long id = Integer.parseInt(s[0]);
			int capacity = Integer.parseInt(s[2]);
			wards.add(new Ward(id, s[1], capacity));
			line = br.readLine();
		}
	}

	public void parseMovements(String filename) throws IOException {
		moves = new ArrayList<Movement>();
		Path path = Paths.get(filename);
		BufferedReader br = Files.newBufferedReader(path);
		String line = br.readLine();
		line = br.readLine();
		while (line != null) {
//			System.out.println(line);
			String[] s = line.split(",");
			long id = Integer.parseInt(s[0]);
			long patient_id = Integer.parseInt(s[1]);
			long from = -1;
			if (s[2].contains("0123456789"))
				from = Integer.parseInt(s[2]);
			long to = -1;
			if (s[3].contains("0123456789"))
				to = Integer.parseInt(s[3]);
			String[] d = s[4].split("-");
			LocalDateTime dt = LocalDateTime.of(Integer.parseInt(d[0]), Integer.parseInt(d[1]), Integer.parseInt(d[2]), 0, 0);
			moves.add(new Movement(id, patient_id, from, to, dt));
			line=br.readLine();
		}
	}
	
	public static void main(String[] args) {
		CSVParser me=new CSVParser();
		
	}
}
