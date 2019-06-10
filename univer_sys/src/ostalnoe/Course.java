package ostalnoe;

import java.lang.*;
import java.util.*;

public class Course {
    String name;

    public Vector<CourseType> courseTypes;

    public Course(String n, Vector<CourseType> c) {
        name = n;
        courseTypes = c;
    }

    public String getName() {
        return name;
    }

    public void setCourseTypes(Vector<CourseType> courseTypes) {
        this.courseTypes = courseTypes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vector<CourseType> getCourseTypes() {
        return courseTypes;
    }
}

