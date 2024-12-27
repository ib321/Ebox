package com.ib;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FindJob {

	public static void main(String[] args) throws IOException {
		FindJobs();
	}

	public static void FindJobs() throws IOException {
		ListJobs li = new ListJobs();
		// li.printAllJobs();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("Let's Find a suitable opportunity for you.\nShall we...\nLet's start");
			System.out.println("*********************");
			System.out.println("Enter SubArea(eg: Noida) or press Enter to skip");
			String subarea = br.readLine();
			System.out.println("Enter Sub Band(eg: E1.1) or press Enter to skip");
			String subband = br.readLine();
			System.out.println("Enter any Primary skill(eg: java) or press Enter to skip");
			String primaryskill = br.readLine();
			System.out.println("Enter Experience(eg: fresher,0,2.5,3,4) or press Enter to skip");
			String exp = br.readLine();

			ArrayList<Opportunity> list = li.filterJob("", primaryskill, "", "", subband, exp, "", subarea);

			for (Opportunity opr : list) {
				System.out.println("------------------------------------------------");
				System.out.println(opr);
				System.out.println("______");
				System.out.println("Exp. Required:-" + opr.Experience);
				System.out.println("Primary Skills:- " + opr.PrimarySkills);
				System.out.println("Secondary Skills:- " + opr.SecondarySkills);
				System.out.println("Designation:- " + opr.Designation);
				System.out.println("JD:- " + opr.JobDescription);
				System.out.println("Contact point1:- " + opr.TP1);
				System.out.println("Contact point2:- " + opr.TP2);
				System.out.println("------------------------------------------------");
			}

			if (list.isEmpty())
				System.out.println("No Match found Please change Your criteria");

			System.out.println("Wish to continue. y/n");
			if (br.readLine().equalsIgnoreCase("n"))
				break;
		}
	}
}

class ListJobs {
	public static ArrayList<Opportunity> list = new ArrayList<Opportunity>();

	public ListJobs() {
		try {
			File file = new File("MyMiscProjects\\\\FindJob\\\\dump.xlsx");
			FileInputStream fis = new FileInputStream(file);

			// creating Workbook instance that refers to .xlsx file
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			// creating a Sheet object to retrieve object
			XSSFSheet sheet = wb.getSheetAt(0);
			// iterating over excel file
			Iterator<Row> itr2 = sheet.iterator();

			while (itr2.hasNext()) {
				int c = 0;
				Opportunity opr = new Opportunity();
				Row row = itr2.next();
				Cell cell1 = row.getCell(c);
				if (cell1.getCellType() == Cell.CELL_TYPE_STRING)
					if (cell1 != null)
						opr.setPrfid(cell1.getStringCellValue());
				if (cell1.getCellType() == Cell.CELL_TYPE_NUMERIC) {
					if (cell1 != null)
						opr.setPrfid(String.valueOf(cell1.getNumericCellValue()));
				}

				Cell cell2 = row.getCell(++c);
				if (cell2 != null)
					opr.setReqNo(cell2.getStringCellValue());

				Cell cell3 = row.getCell(++c);
				if (cell3 != null)
					opr.setJoiningLevel1(cell3.getStringCellValue());

				Cell cell4 = row.getCell(++c);
				if (cell4 != null)
					opr.setJoiningLevel2(cell4.getStringCellValue());

				Cell cell5 = row.getCell(++c);
				if (cell5 != null)
					opr.setJoiningLevel3(cell5.getStringCellValue());

				Cell cell6 = row.getCell(++c);
				if (cell6 != null)
					opr.setJoiningLevel4(cell6.getStringCellValue());

				Cell cell7 = row.getCell(++c);
				if (cell7 != null)
					opr.setInitiator(cell7.getStringCellValue());

				Cell cell8 = row.getCell(++c);
				if (cell8 != null)
					opr.setStatus(cell8.getStringCellValue());

				Cell cell9 = row.getCell(++c);
				if (cell9 != null)
					opr.setPrimarySkills(cell9.getStringCellValue());

				Cell cell10 = row.getCell(++c);
				if (cell10 != null)
					opr.setSecondarySkills(cell10.getStringCellValue());

				Cell cell11 = row.getCell(++c);
				if (cell11 != null)
					opr.setPrimarySkillCategory(cell11.getStringCellValue());

				Cell cell12 = row.getCell(++c);
				if (cell12 != null)
					opr.setPrimarySkillArea(cell12.getStringCellValue());

				Cell cell13 = row.getCell(++c);
				if (cell13 != null)
					opr.setBand(cell13.getStringCellValue());

				Cell cell14 = row.getCell(++c);
				if (cell14 != null)
					opr.setSubband(cell14.getStringCellValue());

				Cell cell15 = row.getCell(++c);
				if (cell15 != null)
					opr.setDesignation(cell15.getStringCellValue());

				Cell cell16 = row.getCell(++c);
				if (cell16 != null)
					opr.setExperience(cell16.getStringCellValue());

				Cell cell17 = row.getCell(++c);
				if (cell17 != null)
					opr.setJobFamily(cell17.getStringCellValue());

				Cell cell18 = row.getCell(++c);
				if (cell18 != null)
					opr.setJob(cell18.getStringCellValue());

				Cell cell19 = row.getCell(++c);
				if (cell19 != null)
					opr.setJobDescription(cell19.getStringCellValue());

				Cell cell20 = row.getCell(++c);
				if (cell20 != null)
					opr.setCountry(cell20.getStringCellValue());

				Cell cell21 = row.getCell(++c);
				if (cell21 != null)
					opr.setPersonalArea(cell21.getStringCellValue());

				Cell cell22 = row.getCell(++c);
				if (cell22 != null)
					opr.setPersonalSubArea(cell22.getStringCellValue());

				Cell cell23 = row.getCell(++c);
				if (cell23 != null)
					opr.setTP1(cell23.getStringCellValue());

				Cell cell24 = row.getCell(++c);
				if (cell24 != null)
					opr.setTP2(cell24.getStringCellValue());

				list.add(opr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void printAllJobs() {
		for (Opportunity op : ListJobs.list) {
			// System.out.print(op.getPrfid() + "\t\t");
			// System.out.print(op.getReqNo() + "\t\t");
			System.out.println(op);
			System.out.println();
		}
		// System.out.println(Arrays.toString(list.toArray()));
	}

	public ArrayList<Opportunity> filterJob(String ReqNo, String PrimarySkills, String SecondarySkills, String Band,
			String Subband, String Experience, String country, String PersonalSubArea) {
		ArrayList<Opportunity> oppFilteredList = new ArrayList<Opportunity>();
		for (Opportunity op : ListJobs.list) {
			boolean f1 = true;
			if (!PersonalSubArea.isEmpty()) {
				f1 = op.getPersonalSubArea().toLowerCase().contains(PersonalSubArea.toLowerCase());
			}

			boolean f2 = true;
			if (!Subband.isEmpty()) {
				f2 = op.getSubband().toLowerCase().contains(Subband.toLowerCase());
			}

			boolean f3 = true;
			if (!PrimarySkills.isEmpty()) {
				f3 = op.getPrimarySkills().toLowerCase().contains(PrimarySkills.toLowerCase());
			}

			boolean f4 = true;
			if (!Experience.isEmpty()) {
				f4 = op.getExperience().toLowerCase().contains(Experience.toLowerCase());
			}

			boolean flag = f1 && f2 && f3 && f4;
			if (flag) {
				oppFilteredList.add(op);
			}
		}
		return oppFilteredList;
	}
}

class Opportunity {
	String prfid;
	String ReqNo;
	String JoiningLevel1;
	String JoiningLevel2;
	String JoiningLevel3;
	String JoiningLevel4;
	String Initiator;
	String Status;
	String PrimarySkills;
	String SecondarySkills;
	String PrimarySkillCategory;
	String PrimarySkillArea;
	String Band;
	String Subband;
	String Designation;
	String Experience;
	String JobFamily;
	String Job;
	String JobDescription;
	String country;
	String PersonalArea;
	String PersonalSubArea;
	String TP1;
	String TP2;

	public String getPrfid() {
		return prfid;
	}

	public void setPrfid(String prfid) {
		this.prfid = prfid;
	}

	public String getReqNo() {
		return ReqNo;
	}

	public void setReqNo(String reqNo) {
		ReqNo = reqNo;
	}

	public String getJoiningLevel1() {
		return JoiningLevel1;
	}

	public void setJoiningLevel1(String joiningLevel1) {
		JoiningLevel1 = joiningLevel1;
	}

	public String getJoiningLevel2() {
		return JoiningLevel2;
	}

	public void setJoiningLevel2(String joiningLevel2) {
		JoiningLevel2 = joiningLevel2;
	}

	public String getJoiningLevel3() {
		return JoiningLevel3;
	}

	public void setJoiningLevel3(String joiningLevel3) {
		JoiningLevel3 = joiningLevel3;
	}

	public String getJoiningLevel4() {
		return JoiningLevel4;
	}

	public void setJoiningLevel4(String joiningLevel4) {
		JoiningLevel4 = joiningLevel4;
	}

	public String getInitiator() {
		return Initiator;
	}

	public void setInitiator(String initiator) {
		Initiator = initiator;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getPrimarySkills() {
		return PrimarySkills;
	}

	public void setPrimarySkills(String primarySkills) {
		PrimarySkills = primarySkills;
	}

	public String getSecondarySkills() {
		return SecondarySkills;
	}

	public void setSecondarySkills(String secondarySkills) {
		SecondarySkills = secondarySkills;
	}

	public String getPrimarySkillCategory() {
		return PrimarySkillCategory;
	}

	public void setPrimarySkillCategory(String primarySkillCategory) {
		PrimarySkillCategory = primarySkillCategory;
	}

	public String getPrimarySkillArea() {
		return PrimarySkillArea;
	}

	public void setPrimarySkillArea(String primarySkillArea) {
		PrimarySkillArea = primarySkillArea;
	}

	public String getBand() {
		return Band;
	}

	public void setBand(String band) {
		Band = band;
	}

	public String getSubband() {
		return Subband;
	}

	public void setSubband(String subband) {
		Subband = subband;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public String getExperience() {
		return Experience;
	}

	public void setExperience(String experience) {
		Experience = experience;
	}

	public String getJobFamily() {
		return JobFamily;
	}

	public void setJobFamily(String jobFamily) {
		JobFamily = jobFamily;
	}

	public String getJob() {
		return Job;
	}

	public void setJob(String job) {
		Job = job;
	}

	public String getJobDescription() {
		return JobDescription;
	}

	public void setJobDescription(String jobDescription) {
		JobDescription = jobDescription;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPersonalArea() {
		return PersonalArea;
	}

	public void setPersonalArea(String personalArea) {
		PersonalArea = personalArea;
	}

	public String getPersonalSubArea() {
		return PersonalSubArea;
	}

	public void setPersonalSubArea(String personalSubArea) {
		PersonalSubArea = personalSubArea;
	}

	public String getTP1() {
		return TP1;
	}

	public void setTP1(String tP1) {
		TP1 = tP1;
	}

	public String getTP2() {
		return TP2;
	}

	public void setTP2(String tP2) {
		TP2 = tP2;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Opportunity [prfid=");
		builder.append(prfid);
		builder.append(", ReqNo=");
		builder.append(ReqNo);
		builder.append(", JoiningLevel1=");
		builder.append(JoiningLevel1);
		builder.append(", JoiningLevel2=");
		builder.append(JoiningLevel2);
		builder.append(", JoiningLevel3=");
		builder.append(JoiningLevel3);
		builder.append(", JoiningLevel4=");
		builder.append(JoiningLevel4);
		builder.append(", Initiator=");
		builder.append(Initiator);
		builder.append(", Status=");
		builder.append(Status);
		builder.append(", PrimarySkills=");
		builder.append(PrimarySkills);
		builder.append(", SecondarySkills=");
		builder.append(SecondarySkills);
		builder.append(", PrimarySkillCategory=");
		builder.append(PrimarySkillCategory);
		builder.append(", PrimarySkillArea=");
		builder.append(PrimarySkillArea);
		builder.append(", Band=");
		builder.append(Band);
		builder.append(", Subband=");
		builder.append(Subband);
		builder.append(", Designation=");
		builder.append(Designation);
		builder.append(", Experience=");
		builder.append(Experience);
		builder.append(", JobFamily=");
		builder.append(JobFamily);
		builder.append(", Job=");
		builder.append(Job);
		builder.append(", JobDescription=");
		builder.append(JobDescription);
		builder.append(", country=");
		builder.append(country);
		builder.append(", PersonalArea=");
		builder.append(PersonalArea);
		builder.append(", PersonalSubArea=");
		builder.append(PersonalSubArea);
		builder.append(", TP1=");
		builder.append(TP1);
		builder.append(", TP2=");
		builder.append(TP2);
		builder.append("]");
		return builder.toString();
	}

}
