# CS542: Assignment 1
## Name: Venkata Achyuth Kunchapu
-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on project.
#### Note: build.xml is present in studentCoursesBackup/src folder.
#### Note: courseInfo.txt, coursePrefs.txt, errorLog.txt, regConflicts.txt, and regResults.txt to be placed in same directory level as src

Assumptions : Input files are well formatted, and no dupulicates

-----------------------------------------------------------------------
## How to clean ?

Command: ant -buildfile studentCoursesBackup/src/build.xml clean

Description: It cleans up all the .class files that were generated when code was compiled.

-----------------------------------------------------------------------
## How to compile ?

Command: ant -buildfile studentCoursesBackup/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## How to run ?

Command: ant -buildfile studentCoursesBackup/src/build.xml run -Darg0=coursePrefs.txt -Darg1=courseInfo.txt -Darg2=regResults.txt -Darg3=regConflicts.txt -Darg4=errorLog.txt

-----------------------------------------------------------------------
## Sample Input 

#### coursePrefs.txt

111 D C A B G I H F G;<br/>
222 F E D C B A H I G;<br/>
333 D A F E I C H B G;<br/>

#### courseInfo.txt

A:30:1<br/>
B:40:2<br/>
C:50:3<br/>
D:60:1<br/>
E:70:7<br/>
F:35:4<br/>
G:45:3<br/>
H:55:7<br/>
I:25:6<br/>

## Output


#### regResults.txt

111:D,C,B::SatisfactionRating=7.67<br/>
222:F,E,D::SatisfactionRating=8.00<br/>
333:D,F,E::SatisfactionRating=7.33<br/>
...<br/>
AverageSatisfactionRating=7.67<br/>

#### regConflicts.txt

Clashing Courses: [A] with allocated course for Student ID 111<br/>
Clashing Courses: [A] with allocated course for Student ID 333<br/>

#### errorLog.txt



-----------------------------------------------------------------------
## Description:


-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.""

Date: -- 


