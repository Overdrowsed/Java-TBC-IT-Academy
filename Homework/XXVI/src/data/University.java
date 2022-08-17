package data;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@SuppressWarnings("unused")
public class University implements Serializable{
    String name;
    transient Address address;

    public University(String name, Address address) {
        this.name = name;
        this.address = address;
    }

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
        return "University [address=" + address + ", name=" + name + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        University other = (University) obj;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}



// public class University implements Externalizable{
//     String name;
//     transient Address address;

//     public University(String name, Address address) {
//         this.name = name;
//         this.address = address;
//     }

//     public University() {}

//     @Override
// 	public void readExternal(ObjectInput input) throws IOException, ClassNotFoundException {
// 		this.name = input.readUTF();
//         this.address = (Address)input.readObject();
// 	}

// 	@Override
// 	public void writeExternal(ObjectOutput output) throws IOException {
// 		output.writeUTF(name);
// 		output.writeObject(address);
// 	}

//     @Override
//     public String toString() {
//         return "University [address=" + address + ", name=" + name + "]";
//     }

//     @Override
//     public boolean equals(Object obj) {
//         if (this == obj)
//             return true;
//         if (obj == null)
//             return false;
//         if (getClass() != obj.getClass())
//             return false;
//         University other = (University) obj;
//         if (address == null) {
//             if (other.address != null)
//                 return false;
//         } else if (!address.equals(other.address))
//             return false;
//         if (name == null) {
//             if (other.name != null)
//                 return false;
//         } else if (!name.equals(other.name))
//             return false;
//         return true;
//     }
// }
