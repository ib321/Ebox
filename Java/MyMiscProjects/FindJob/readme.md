# FindJob

**FindJob** is a console-based Java project designed to find job.
I had built this to overcome one issue that we were facing in HCL we used to get a job dump file which was an excel sheet with 30000-40000 entries.
the issue was many of those vacancy were old many were of different technology experience.
manually searching and finding the opportunity was a hard task.
So using this console based project which is strictly based on that excel dump format.
user can enter some inputs it ask like Skill experience location e.t.c
then it shows the possible matches and details of contact person and description of those matches.

## Requirements
- **Add Jars to build path**: Add all required jars to build path.
- **Excel Input Dump File**: User need to provide input dump file.
Header Demo of Dump File:
prfid	ReqNo	Joining Level 1	Joining Level 2	Joining Level 3	Joining Level 4	Initiator	Status	Primary Skills	Secondary Skills	Primary Skill Category	Primary Skill Area	Band	Sub band	Designation	Experience	Job Family	Job	JobDescription	country	Personal Area	Personal SubArea	TP1	TP2
Example Value:
19121	HCL/HCL/2022/19121	HCL NV MADURAI	HCL NV MDU-LEADERSHIP	HCL NV MDU-LEADERSHIP-DELIVERY STAFF	HCL NV MDU-LEADERSHIP-DS-APPS	Teja Sri Avuthu  [8224 ]	Approved	Full Stack - Java		Technical Skills	Full Stack Development	TS	T0	SCHOLAR	Fresher	Bench/Training-TSS	Intern		INDIA	HCL TSS	Madurai	Jagadish P  [025]	ANITA IMMANUEL  [306]


## Getting Started
To get started with the LordToni project, follow these steps:

1. **Clone the Repository**: Download or clone the project repository to your local machine.
2. **Add Jars to build path**: It need some external dependencies to run although in future I will convert it into maven based but for now it needs 6 jars to be imported:
c:\Aarambh\Git\Ebox\jar\poi-ooxml-schemas-3.17.jar
c:\Aarambh\Git\Ebox\jar\json-20211205.jar
c:\Aarambh\Git\Ebox\jar\commons-collections4-4.1.jar
c:\Aarambh\Git\Ebox\jar\xmlbeans-2.6.0 (1).jar
c:\Aarambh\Git\Ebox\jar\poi-ooxml-3.17.jar
c:\Aarambh\Git\Ebox\jar\poi-3.17 (1).jar

3. **Run the Program**: Execute the Java program in your console. The program will read the lyrics from the text file and display the count of each word.