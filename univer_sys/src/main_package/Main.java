package main_package;
import enums.*;
import ostalnoe.*;
import ostalnoe.Course;
import user_classes.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Main {
    public static BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
    static Vector<Teacher> teachers = new Vector<Teacher>();
    static Vector<Student> students = new Vector<Student>();
    static Vector<Course> courses = new Vector<Course>();
    static Vector<Manager> managers = new Vector<Manager>();
    static Vector<Executor> executors = new Vector<Executor>();
    static String adminLogin = "admin";
    static String adminPassword =  "password";
    static Vector<News> news = new Vector<News>();
    public static void main(String args[]) throws IOException{
        startAdmin1();
        start();
    }
    public static boolean checkAdmin(String username,String password){
        if(username==adminLogin&&password==adminPassword)return true;
        return false;
    }


    public static void startAdmin1(){
        Teacher zhango = new Teacher("id228", "123321", "id228", "some1", "some1", Position.Professor);
        Teacher zhango2 = new Teacher("id229", "123321", "id229", "some1", "some1", Position.Tutor);

        teachers.add(zhango);
        teachers.add(zhango2);

        Vector <CourseType> v = new Vector<CourseType>();

        Student Gulim = new Student("g_alkenova", "alknen222", "17BD01", "Gulim", "Alkenova");

        Student Zhuzya = new Student("z_zhuzya", "zhuzya111", "17BD02", "Zhuldyzdai", "Toleukhan");

        students.add(Gulim);
        students.add(Zhuzya);

        Mark mark1 = new Mark(20,20,40);
        Mark mark2 = new Mark(10,10,0 );

        Mark mark3 = new Mark(15,15,30);
        Mark mark4 = new Mark(6,7,0 );


        HashMap<Student,Mark> m1 = new HashMap<Student, Mark>() {};
        m1.put(Gulim,mark1);
        m1.put(Zhuzya,mark3);

        Time time = new Time (6,9);
        CourseType SIS = new CourseType(TypeOfCourse.Practical,zhango,335,time, m1);

        HashMap<Student,Mark> m2 = new HashMap<Student, Mark>() {};
        m2.put(Gulim,mark2);
        m2.put(Zhuzya,mark4);

        Time time1 = new Time (6,11);
        CourseType SIS1 = new CourseType(TypeOfCourse.Lecture,zhango,441,time1, m2);

        v.add(SIS);
        v.add(SIS1);

        Course Acm = new Course("acm",v);
        courses.add(Acm);

        Order functionOfKulPaw = new Order("Clean floor");
        Order functionOfKulPaw2 = new Order("Clean windows");

        Vector <Order> universalKulpaw = new Vector<Order>();
        universalKulpaw.add(functionOfKulPaw);
        universalKulpaw.add(functionOfKulPaw2);

        Executor Kulpaw = new Executor(universalKulpaw, "KUL29", "12345678","id", "Kulpaw",  " Alimovna");
        executors.add(Kulpaw);

        Manager Dariga  = new Manager ("Dariga12", "D12345", "id", "Dariga", "Kulimova");
        managers.add(Dariga);
        News news1 = new News("Football Cup","There will be a football cup at 19-00 in front of Kbtu(street Tole bi)", "2/00/2017", Dariga);

        news.add(news1);
    }

    public static void start() throws IOException{
        System.out.println("Enter your login and password");
        String username = console.readLine(),password = console.readLine();
        if(username.equals(adminLogin) && password.equals(adminPassword)){
            startAdmin();
        }
        else {
            boolean ok =false;
            for(int  i=0;i<students.size();i++){
                if(students.get(i).getLogin().equals(username) &&
                        students.get(i).getPassword().equals(password)){
                    startStudent(students.get(i));
                    ok=true;
                    break;
                }
            }
            if(!ok){
                for(int i=0; i < teachers.size(); i++){
                    if(teachers.get(i).getLogin().equals(username) && teachers.get(i).getPassword().equals(password)){
                        startTeacher(teachers.get(i));
                        ok = true;
                        break;
                    }
                }
            }
            if(!ok){
                for(int i=0; i < executors.size(); i++){
                    if(executors.get(i).getLogin().equals(username) && executors.get(i).getPassword().equals(password)){
                        startExecutor(executors.get(i));
                        ok = true;
                        break;
                    }
                }
            }
            if(!ok){
                for(int i=0; i < managers.size(); i++){
                    if(managers.get(i).getLogin().equals(username) && managers.get(i).getPassword().equals(password)){
                        startManager(managers.get(i));
                        ok = true;
                        break;
                    }
                }
            }
            if(!ok){
                System.out.println("You are not registered! Enter correct data!");
                start();
            }
        }

    }


    public static void startAdmin() throws IOException{
        System.out.println("Hello Admin, choose your option below");
        System.out.println("1) Add student");
        System.out.println("2) Erase student");
        System.out.println("3) Add teacher");
        System.out.println("4) Erase teacher");
        System.out.println("5) Add manager");
        System.out.println("6) Erase manager");
        System.out.println("7) Add executor");
        System.out.println("8) Erase executor");
        System.out.println("9) Exit");

        int choice = Integer.parseInt(console.readLine());

        switch(choice){
            case 1: addStudent();
            case 2: eraseStudent();
            case 3: addTeacher();
            case 4: eraseTeacher();
            case 5: addManager();
            case 6: eraseManager();
            case 7: addExecutor();
            case 8: eraseExecutor();
            case 9: break;
            default: System.out.println("Invalid optiion"); startAdmin();
        }
    }

    public static void addStudent() throws IOException{
        System.out.println("Enter login, password, id, full name, id line by line");

        String newLogin = console.readLine(), newPassword = console.readLine(), newFullname = console.readLine(), newID = console.readLine();
        students.add(new Student(newLogin, newPassword, newID, newFullname, newID));

        System.out.println("succesully added");
        startAdmin();

    }
    public static void eraseStudent() throws IOException{
        if(students.size()==0){
            System.out.println("Sorry but there are no students yet");
            startAdmin();
        }

        System.out.println("Which student do you want to erase");

        for(int i = 0; i < students.size(); i++){
            System.out.println(i+1+")" + students.get(i).getFullname());
        }

        int index = Integer.parseInt(console.readLine());
        if(index>students.size()){
            System.out.println("plz enter valid data");
            eraseStudent();
        }
        students.remove(index-1);
        System.out.println("succesully removed");
        startAdmin();
    }

    public static void addTeacher() throws IOException{
        System.out.println("Enter login, password, full name and choose position line by line");

        String newLogin = console.readLine(), newPassword = console.readLine(), newFullname = console.readLine();

        System.out.println("1) Lecturer");
        System.out.println("2) Professor");
        System.out.println("3) Tutor");
        int choice = Integer.parseInt(console.readLine());
        if(choice==1)
            teachers.add(new Teacher(newLogin, newPassword, "123", newFullname,"..", Position.Lecturer));
        else if(choice==2)
            teachers.add(new Teacher(newLogin, newPassword, "123", newFullname,"..", Position.Professor));
        else if(choice==3)
            teachers.add(new Teacher(newLogin, newPassword, "123", newFullname,"..", Position.Tutor));

        System.out.println("succesully added");
        startAdmin();

    }
    public static void eraseTeacher() throws IOException{
        if(teachers.size()==0){
            System.out.println("Sorry but there are no teachers yet");
            startAdmin();
        }
        System.out.println("Which teacher do you want to erase");
        for(int i = 0; i < teachers.size(); i++){
            System.out.println(i+1+")" + teachers.get(i).getFullname());
        }

        int index = Integer.parseInt(console.readLine());
        if(index>teachers.size()){
            System.out.println("plz enter valid data");
            eraseTeacher();
        }
        teachers.remove(index-1);
        System.out.println("succesully removed");
        startAdmin();
    }

    public static void addManager() throws IOException{
        System.out.println("Enter login, password, full name, degree line by line");

        String newLogin = console.readLine(), newPassword = console.readLine(), newFullname = console.readLine(), newDegree = console.readLine();
        managers.add(new Manager(newLogin, newPassword, newFullname, "some1", "some1"));
        System.out.println("succesully added");
        startAdmin();

    }
    public static void eraseManager() throws IOException{
        if(managers.size()==0){
            System.out.println("Sorry but there are no managers yet");
            startAdmin();
        }

        System.out.println("Which manager do you want to erase");
        for(int i = 0; i < managers.size(); i++){
            System.out.println(i+1+")" + managers.get(i).getFullname());
        }

        int index = Integer.parseInt(console.readLine());
        if(index>managers.size()){
            System.out.println("Plz enter a valid data");
            eraseManager();
        }
        managers.remove(index-1);
        System.out.println("succesully removed");
        startAdmin();
    }

    public static void addExecutor() throws IOException{
        System.out.println("Enter login, password, full name, and number functions line by line");

        String newLogin = console.readLine(), newPassword = console.readLine(), newFullname = console.readLine();
        int number = Integer.parseInt(console.readLine());
        Vector<Order> v=new Vector<Order>();
        System.out.println("Plz write functions of a executor one by one");
        for(int i=0;i<number;i++){
            String s = console.readLine();
            v.add(new Order(s));
        }

        executors.add(new Executor(v,newLogin, newPassword, "id", newFullname, "."));

        System.out.println("succesully added");
        startAdmin();

    }
    public static void eraseExecutor() throws IOException{
        if(executors.size()==0){
            System.out.println("Sorry but there are no executors yet");
            startAdmin();
        }
        System.out.println("Which executor do you want to erase");
        for(int i = 0; i < executors.size(); i++){
            System.out.println(i+1+")" + executors.get(i).getFullname());
        }

        int index = Integer.parseInt(console.readLine());
        if(index>executors.size()){
            System.out.println("Plz enter a valid data");
            eraseExecutor();
        }
        executors.remove(index-1);
        System.out.println("succesully removed");
        startAdmin();
    }



    public static void startStudent(Student student) throws IOException{
        System.out.println("Hello, " + student.getFullname());
        System.out.println("Plz choose one of the options:");
        System.out.println("1) News");
        System.out.println("2) Schedule");
        System.out.println("3) Marks");
        System.out.println("4) Teachers");
        System.out.println("5) Exit");
        int choice = Integer.parseInt(console.readLine());
        switch(choice){
            case 1: viewNews(student);
            case 2: viewSchedule(student);
            case 3: viewMarks(student);
            case 4: teachersOpertions(student);
            case 5: start();
            default: System.out.println("Invalid optiion"); startStudent(student);
        }
    }

    public static void viewNews(Student student) throws IOException{
        for(int i=0;i<news.size();i++){
            System.out.println(news.get(i).getTitle());
            System.out.println(news.get(i).getText());
            System.out.println("Author: " +  news.get(i).getAuthor().getFullname());
            System.out.println("Date: " + news.get(i).getDate());
        }
        System.out.println("********************************");
        startStudent(student);
    }
    public static void viewSchedule(Student student) throws  IOException{
        for(int i=0;i<courses.size();i++){
            Course course = courses.get(i);
            Vector<CourseType> v = course.getCourseTypes();
            for(int j=0;j<v.size();j++){
                CourseType c = v.get(j);
                Time time = c.getTime();
                HashMap<Student,Mark> h = c.getStudents();
                if(h.containsKey(student)){
                    System.out.println(time.getDay() + " " + time.getHour() + ":00 " + course.getName() + " " + c.getType() +" " + c.getRoom() + " cab");

                }
            }
        }

        System.out.println("********************************");
        startStudent(student);
    }

    public static void teachersOpertions(Student student) throws IOException{
        System.out.println("Plz choose one of the options below");
        System.out.println("1) See Teachers");
        System.out.println("2) See Teacher's schedule");
        System.out.println("3) See Teacher's Coursefiles");
        int choice = Integer.parseInt(console.readLine());
        switch (choice){
            case 1: viewTeachers(student);
            case 2: {
                int cnt=0;
                for(int i=0;i<courses.size();i++){
                    Course course = courses.get(i);
                    Vector<CourseType> v = course.getCourseTypes();
                    for(int j=0;j<v.size();j++){
                        CourseType c = v.get(j);
                        HashMap<Student,Mark> h = c.getStudents();
                        if(h.containsKey(student)){
                            System.out.println((cnt+1) + ") " + c.getTeacher().getFullname());
                            cnt++;
                        }
                    }
                }
                int choice1 = Integer.parseInt(console.readLine());
                cnt=0;
                for(int i=0;i<courses.size();i++){
                    Course course = courses.get(i);
                    Vector<CourseType> v = course.getCourseTypes();
                    for(int j=0;j<v.size();j++){
                        CourseType c = v.get(j);
                        HashMap<Student,Mark> h = c.getStudents();
                        if(h.containsKey(student)){
                            System.out.println(c.getTeacher().getFullname());
                            cnt++;
                            if(cnt==choice1){
                                Teacher teacher = c.getTeacher();
                                for(int ii=0;ii<courses.size();ii++){
                                    for(int jj=0;jj<courses.get(ii).getCourseTypes().size();jj++){
                                        CourseType ct = courses.get(ii).getCourseTypes().get(jj);
                                        if(ct.getTeacher()==teacher){
                                            System.out.println(courses.get(ii).getName() + " " + ct.getTime().getDay() + " " + ct.getTime().getHour() + ":00 " + " " + ct.getRoom() + " cab");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                System.out.println("********************************");
                startStudent(student);
            }
            case 3:{
                int cnt=0;
                for(int i=0;i<courses.size();i++){
                    Course course = courses.get(i);
                    Vector<CourseType> v = course.getCourseTypes();
                    for(int j=0;j<v.size();j++){
                        CourseType c = v.get(j);
                        HashMap<Student,Mark> h = c.getStudents();
                        if(h.containsKey(student)){
                            System.out.println((cnt+1) + ") " + c.getTeacher().getFullname());
                            cnt++;
                        }
                    }
                }
                int choice1 = Integer.parseInt(console.readLine());
                cnt=0;
                for(int i=0;i<courses.size();i++){
                    Course course = courses.get(i);
                    Vector<CourseType> v = course.getCourseTypes();
                    for(int j=0;j<v.size();j++){
                        CourseType c = v.get(j);
                        HashMap<Student,Mark> h = c.getStudents();
                        if(h.containsKey(student)){
                            System.out.println(c.getTeacher().getFullname());
                            cnt++;
                            if(cnt==choice1){
                                Teacher teacher = c.getTeacher();
                                for(int ii=0;ii<courses.size();ii++){
                                    for(int jj=0;jj<courses.get(ii).getCourseTypes().size();jj++){
                                        CourseType ct = courses.get(ii).getCourseTypes().get(jj);
                                        if(ct.getTeacher()==teacher){
                                            for(int k=0;k<ct.getCourseFiles().size();k++){
                                                System.out.println(courses.get(ii).getName());
                                                System.out.println(ct.getCourseFiles().get(k).getTitle());
                                                System.out.println(ct.getCourseFiles().get(k).getText());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                System.out.println("********************************");
                startStudent(student);
            }
        }
    }


    public static void viewMarks(Student student) throws IOException{
        for(int i=0;i<courses.size();i++){
            Course course = courses.get(i);
            Vector<CourseType> v = course.getCourseTypes();
            for(int j=0;j<v.size();j++){
                CourseType c = v.get(j);
                Time time = c.getTime();
                HashMap<Student,Mark> h = c.getStudents();
                if(h.containsKey(student)){
                    System.out.println(course.getName() + " " + c.getType() + " " + h.get(student).getFirst() + " " + h.get(student).getSecond() + " " + h.get(student).getFinalPoint());

                }
            }
        }
        System.out.println("********************************");
        startStudent(student);
    }
    public static void viewTeachers(Student student) throws IOException{
        for(int i=0;i<courses.size();i++){
            Course course = courses.get(i);
            Vector<CourseType> v = course.getCourseTypes();
            for(int j=0;j<v.size();j++){
                CourseType c = v.get(j);
                HashMap<Student,Mark> h = c.getStudents();
                if(h.containsKey(student))
                    System.out.println(c.getTeacher().getFullname());
            }
        }
        System.out.println("********************************");
        startStudent(student);
    }

    public static void startTeacher(Teacher teacher) throws IOException{
        System.out.println("Hello, " + teacher.getFullname());
        System.out.println("Please choose what do you want to do");
        System.out.println("1) Options with courses");
        System.out.println("2) Send order to executor");
        System.out.println("3) View news");
        System.out.println("4) View schedule");
        System.out.println("5) Exit");

        int choice = Integer.parseInt(console.readLine());

        switch(choice){
            case 1: optionsWithCourse(teacher);
            case 2: sendOrderToExecutor(teacher);
            case 3: viewNews(teacher);
            case 4: viewSchedule(teacher);
            case 5: start();
            default: System.out.println("Invalid option! Choose correct number from option!"); startTeacher(teacher);
        }
    }
    public static void optionsWithCourse(Teacher teacher) throws IOException{
        System.out.println("Choose Course");
        Vector<Course> c = new Vector<Course>();
        for(int i=0;i<courses.size();i++){
            Course course = courses.get(i);
            Vector<CourseType> v = course.getCourseTypes();
            for(int j=0;j<v.size();j++){
                if(v.get(j).getTeacher() == teacher){
                    c.add(course);
                    System.out.println(c.size() + ") " + course.getName());
                }
            }
        }
        int choice  = Integer.parseInt(console.readLine());
        Course course1 = c.get(choice-1);
        System.out.println("What do you want to do with this course?");
        System.out.println("1) See info about students (full names, marks)");
        System.out.println("2) Manage course files");
        System.out.println("3) Choose student and put marks");
        System.out.println("4) Back");

        int choice1 = Integer.parseInt(console.readLine());
        switch(choice1){
            case 1: seeInfoStudentsOfCourse(teacher, course1);//prints marks and full names;
            case 2: manageCourseFiles(teacher, course1);//adds or removes coursefile
            case 3: putMarks(teacher, course1);//puts mark to course's student
            case 4: {
                System.out.println("********************************");
                startTeacher(teacher);
            }
            default: System.out.println("Invalid option! Choose correct number from option!"); optionsWithCourse(teacher);
        }
    }

    public static void seeInfoStudentsOfCourse(Teacher teacher, Course course) throws IOException{
        for(int i=0;i<courses.size();i++){
            Course course2 = courses.get(i);
            Vector<CourseType> v = course2.getCourseTypes();
            for(int j=0;j<v.size();j++){
                if(v.get(j).getTeacher()==teacher && course2 == course){
                    for(int k =0;k<students.size();k++){
                        Student student = students.get(k);
                        if(v.get(j).getStudents().containsKey(student)){
                            System.out.println(student.getFullname() + ": " + v.get(j).getStudents().get(student).getFirst() + " " + v.get(j).getStudents().get(student).getSecond() + " " + v.get(j).getStudents().get(student).getFinalPoint() );
                        }
                    }
                }
            }
        }
        System.out.println("********************************");
        startTeacher(teacher);
    }

    public static void manageCourseFiles(Teacher teacher, Course course) throws IOException{
        System.out.println("1) See course files");
        System.out.println("2) Add course files");
        System.out.println("3) Remove course files");
        System.out.println("4) Back");
        int choice = Integer.parseInt(console.readLine());

        switch(choice){
            case 1: {
                for(int i=0;i<courses.size();i++){
                    Course course2 = courses.get(i);
                    Vector<CourseType> v = course2.getCourseTypes();
                    for(int j=0;j<v.size();j++){
                        if(v.get(j).getTeacher()==teacher && course2 == course){
                            if(v.get(j).getCourseFiles().size()==0){
                                System.out.println("Sorry but there are no coursefles yet");
                                startTeacher(teacher);
                            }
                            for(int k=0;k<v.get(j).getCourseFiles().size();k++){
                                System.out.println(v.get(j).getCourseFiles().get(k).getTitle());
                                System.out.println(v.get(j).getCourseFiles().get(k).getText());
                            }
                        }
                    }
                }
                System.out.println("********************************");
                startTeacher(teacher);
            }
            case 2: {
                System.out.println("Write Coursefile's title and text line by line");
                String s=console.readLine();
                String x=console.readLine();
                CourseFiles cf = new CourseFiles(s,x);
                for(int i=0;i<courses.size();i++){
                    Course course2 = courses.get(i);
                    Vector<CourseType> v = course2.getCourseTypes();
                    for(int j=0;j<v.size();j++){
                        if(v.get(j).getTeacher()==teacher && course2 == course){

                            Vector<CourseFiles> c = v.get(j).getCourseFiles();
                            c.add(cf);
                            v.get(j).setCourseFiles(c);
                            System.out.println("Succesfully added");
                            System.out.println("********************************");
                            startTeacher(teacher);
                        }
                    }
                }
            }
            case 3: {
                System.out.println("Plz choose which one u want to remove");
                for(int i=0;i<courses.size();i++){
                    Course course2 = courses.get(i);
                    Vector<CourseType> v = course2.getCourseTypes();
                    for(int j=0;j<v.size();j++){
                        if(v.get(j).getTeacher()==teacher && course2 == course){
                            if(v.get(j).getCourseFiles().size()==0){
                                System.out.println("Sorry but there are no coursefles yet");
                                System.out.println("********************************");
                                startTeacher(teacher);
                            }
                            for(int k=0;k<v.get(j).getCourseFiles().size();k++){
                                System.out.println((k + 1) + ") " + v.get(j).getCourseFiles().get(k).getTitle());
                                System.out.println(v.get(j).getCourseFiles().get(k).getText());
                            }
                        }
                    }
                }
                int choice1 = Integer.parseInt(console.readLine());
                for(int i=0;i<courses.size();i++){
                    Course course2 = courses.get(i);
                    Vector<CourseType> v = course2.getCourseTypes();
                    for(int j=0;j<v.size();j++){
                        if(v.get(j).getTeacher()==teacher && course2 == course){
                            Vector<CourseFiles> c = v.get(j).getCourseFiles();
                            c.remove(choice1-1);
                            v.get(j).setCourseFiles(c);
                        }
                    }
                }
                System.out.println("********************************");
                startTeacher(teacher);
            }

            case 4: optionsWithCourse(teacher);
            default: System.out.println("Invalid option! Enter correct option!"); manageCourseFiles(teacher, course);
        }
    }

    public static void putMarks(Teacher teacher, Course course) throws IOException{
        System.out.println("Plz choose a student");
        for(int i=0;i<courses.size();i++){
            for(int j=0;j<courses.get(i).courseTypes.size();j++){
                CourseType ct=courses.get(i).courseTypes.get(j);
                HashMap<Student,Mark> h = ct.getStudents();
                int cnt=0;
                if(teacher == ct.getTeacher()&&course==courses.get(i)){
                    for(Map.Entry<Student,Mark> entry : h.entrySet()){
                        cnt++;
                        System.out.println(cnt + ") " + entry.getKey().getFullname());
                    }
                }
            }
        }
        int choice = Integer.parseInt(console.readLine());
        for(int i=0;i<courses.size();i++){
            for(int j=0;j<courses.get(i).courseTypes.size();j++){
                CourseType ct=courses.get(i).courseTypes.get(j);
                HashMap<Student,Mark> h = ct.getStudents();
                int cnt=0;
                if(teacher == ct.getTeacher()&&course==courses.get(i)){
                    for(Map.Entry<Student,Mark> entry : h.entrySet()){
                        cnt++;
                        if(cnt==choice){
                            System.out.println(entry.getKey().getFullname() + " " + entry.getValue().getFirst() + " " + entry.getValue().getSecond() + " " + entry.getValue().getFinalPoint());
                            System.out.println("Plz write your points for the each of the attestations line by line");
                            double cnt1=Double.parseDouble(console.readLine());
                            double cnt2=Double.parseDouble(console.readLine());
                            double cnt3=Double.parseDouble(console.readLine());
                            entry.getValue().setFirst(cnt1);
                            entry.getValue().setSecond(cnt2);
                            entry.getValue().setFinalPoint(cnt3);
                        }
                    }
                }
            }
        }

        System.out.println("********************************");
        startTeacher(teacher);
    }


    public static void sendOrderToExecutor(Teacher teacher) throws IOException{
        System.out.println("Plz write an order");
        String s = console.readLine();
        Order order = new Order(s);
        boolean b =false;
        for(int i = 0; i < executors.size(); i++){
            if(b)break;
            Executor temp = executors.get(i);
            for(int j = 0; j < temp.getFunctions().size(); j++){
                if(temp.getFunctions().get(j).getTitle().equals(s)){
                    temp.getOrder(order);
                    System.out.println("Succesfully sended to " + temp.getFullname());
                    b=true;
                    break;
                }
            }
        }
        if(!b){
            System.out.println("There is no executor that can do this order");
        }
        System.out.println("********************************");
        startTeacher(teacher);
    }

    public static void viewNews(Teacher teacher) throws IOException{
        for(int i=0;i<news.size();i++){
            System.out.println(news.get(i).getTitle());
            System.out.println(news.get(i).getText());
            System.out.println("Author: " +  news.get(i).getAuthor().getFullname());
            System.out.println("Date: " + news.get(i).getDate());
        }
        System.out.println("********************************");
        startTeacher(teacher);
    }

    public static void viewSchedule(Teacher teacher) throws IOException{
        for(int i=0;i<courses.size();i++){
            for(int j=0;j<courses.get(i).getCourseTypes().size();j++){
                CourseType ct = courses.get(i).getCourseTypes().get(j);
                if(ct.getTeacher()==teacher){
                    System.out.println(courses.get(i).getName() + " " + ct.getTime() + " " + ct.getRoom() + " cab");
                }
            }
        }
        System.out.println("********************************");
        startTeacher(teacher);
    }
    public static void startExecutor(Executor executor) throws IOException{
        System.out.println("Hello, " + executor.getFullname());
        System.out.println("What do u want to do?");
        System.out.println("1) View Orders");
        System.out.println("2) Remove Orders(done orders)");
        System.out.println("3) Add functions");
        System.out.println("4) Exit");
        int choice = Integer.parseInt(console.readLine());
        switch (choice){
            case 1: {
                if(executor.getOrders()==null||executor.getOrders().size()==0){
                    System.out.println("There are no orders for u today");
                    System.out.println("********************************");
                    startExecutor(executor);
                }
                for(int i=0;i<executor.getOrders().size();i++){
                    System.out.println(executor.getOrders().get(i).getTitle());
                }
            }
            case 2: {
                if(executor.getOrders()==null||executor.getOrders().size()==0){
                    System.out.println("There are no orders for u today");
                    System.out.println("********************************");
                    startExecutor(executor);
                }
                System.out.println("Which one u have done ?");
                for(int i=0;i<executor.getOrders().size();i++){
                    System.out.println((i+1) + ") " + executor.getOrders().get(i).getTitle());
                }
                int cnt = Integer.parseInt(console.readLine());
                Vector<Order> orders=executor.getOrders();
                orders.remove(cnt-1);
                executor.setOrders(orders);
                System.out.println("********************************");
                startExecutor(executor);
            }
            case 3: {
                System.out.println("Write your new function plz");
                String s= console.readLine();
                Vector<Order> fun=executor.getFunctions();
                fun.add(new Order(s));
                executor.setFunctions(fun);
                System.out.println("Succesfully added");
                System.out.println("********************************");
                startExecutor(executor);
            }
            case 4: start();
            default: System.out.println("Enter correct option"); startExecutor(executor);
        }
    }
    public static void startManager(Manager manager) throws IOException{
        System.out.println("Hello, " + manager.getFullname());
        System.out.println("Please choose what do you want to do");
        System.out.println("1) Add news");
        System.out.println("2) Add course");
        System.out.println("3) Back");
        System.out.println("4) Exit");

        int choice = Integer.parseInt(console.readLine());

        switch(choice){
            case 1: addNews(manager);
            case 2: addCourse(manager);
            case 3: start();
            default: System.out.println("Invalid option! Choose correct number from option!"); startManager(manager);
        }
    }

    public static void addNews(Manager manager) throws IOException{
        //title text data author
        System.out.println("Please, enter title, text, date for news! ");
        String newTitle = console.readLine();
        String newText = console.readLine();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String currentDate = dateFormat.format(date);

        news.add(new News(newTitle, newText, currentDate, manager));
        System.out.println("Succesfully added");
        System.out.println("********************************");
        startManager(manager);
    }

    public static void addCourse(Manager manager) throws IOException{
        Vector <CourseType> cf = new Vector<CourseType>();
        System.out.println("Please, enter name of course");
        String name = console.readLine();
        courses.add(new Course(name, cf));
        System.out.println("********************************");
        startManager(manager);
    }

}
