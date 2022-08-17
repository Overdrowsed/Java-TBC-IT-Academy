package data;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("unused")
public class Person implements Serializable{
    private static final long serialVersionUID = 7311114603813054698L;

    String firstName, lastName;
    Date birthdate;
    transient Address address;
    
    public Person(String firstName, String lastName, Date birthdate, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.address = address;
    }

    public Person(){}

    private void writeObject(ObjectOutputStream output) throws IOException {
        output.defaultWriteObject();
        output.writeObject(address);
    }
 
    private void readObject(ObjectInputStream input) throws IOException,ClassNotFoundException {
        input.defaultReadObject();
        address = (Address)input.readObject();
    }

    @Override
    public String toString() {
        return "Person [firstName=" + firstName + ", lastname=" + lastName + ", birthdate=" + birthdate + ", address="
                + address + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (birthdate == null) {
            if (other.birthdate != null)
                return false;
        } else if (!birthdate.equals(other.birthdate))
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        return true;
    }   
}



// public class Person implements Externalizable{
//     private static final long serialVersionUID = 7311114603813054698L;

//     String firstName, lastName;
//     Date birthdate;
//     transient Address address;
    
//     public Person(String firstName, String lastName, Date birthdate, Address address) {
//         this.firstName = firstName;
//         this.lastName = lastName;
//         this.birthdate = birthdate;
//         this.address = address;
//     }

//     public Person(){}

//     @Override
// 	public void readExternal(ObjectInput input) throws IOException, ClassNotFoundException {
// 	    this.firstName = input.readUTF();
//         this.lastName = input.readUTF();
//         this.birthdate = (Date)input.readObject();
//         this.address = (Address)input.readObject();
// 	}

// 	@Override
// 	public void writeExternal(ObjectOutput output) throws IOException {
// 		output.writeUTF(firstName);
// 		output.writeUTF(lastName);
// 		output.writeObject(birthdate);
// 		output.writeObject(address);
// 	}
//     @Override
//     public String toString() {
//         return "Person [firstName=" + firstName + ", lastname=" + lastName + ", birthdate=" + birthdate + ", address="
//                 + address + "]";
//     }

//     @Override
//     public boolean equals(Object obj) {
//         if (this == obj)
//             return true;
//         if (obj == null)
//             return false;
//         if (getClass() != obj.getClass())
//             return false;
//         Person other = (Person) obj;
//         if (address == null) {
//             if (other.address != null)
//                 return false;
//         } else if (!address.equals(other.address))
//             return false;
//         if (birthdate == null) {
//             if (other.birthdate != null)
//                 return false;
//         } else if (!birthdate.equals(other.birthdate))
//             return false;
//         if (firstName == null) {
//             if (other.firstName != null)
//                 return false;
//         } else if (!firstName.equals(other.firstName))
//             return false;
//         if (lastName == null) {
//             if (other.lastName != null)
//                 return false;
//         } else if (!lastName.equals(other.lastName))
//             return false;
//         return true;
//     }
// }
