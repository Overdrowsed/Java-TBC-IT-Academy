package data;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

@SuppressWarnings("unused")
public class Student extends Person {
    private static final long serialVersionUID = 2L;

    int course;
    University university;
    double gpa;

    public Student(String firstName, String lastName, Date birthdate, Address address, int course, University university, double gpa) {
        super(firstName, lastName, birthdate, address);
        this.course = course;
        this.university = university;
        this.gpa = gpa;
    }

    public Student(){}
    
    // ქვედა ორი @Override იმ შემთხვევაში თუ მშობელი კლასი Person implements Externalizable
    // @Override
	// public void readExternal(ObjectInput input) throws IOException, ClassNotFoundException {
	//     this.firstName = input.readUTF();
    //     this.lastName = input.readUTF();
    //     this.birthdate = (Date)input.readObject();
    //     this.address = (Address)input.readObject();
    //     this.course = input.readInt();
    //     this.university = (University)input.readObject();
    //     this.gpa = input.readDouble();
	// }

	// @Override
	// public void writeExternal(ObjectOutput output) throws IOException {
	// 	output.writeUTF(firstName);
	// 	output.writeUTF(lastName);
	// 	output.writeObject(birthdate);
	// 	output.writeObject(address);
    //     output.writeInt(course);
    //     output.writeObject(university);
    //     output.writeDouble(gpa);
	// }

    @Override
    public String toString() {
        return "Student [firstName=" + firstName + ", lastname=" + lastName + ", birthdate=" + birthdate + ", address="
                + address + ", course=" + course + ", university=" + university + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (course != other.course)
            return false;
        if (Double.doubleToLongBits(gpa) != Double.doubleToLongBits(other.gpa))
            return false;
        if (university == null) {
            if (other.university != null)
                return false;
        } else if (!university.equals(other.university))
            return false;
        return true;
    }
}
