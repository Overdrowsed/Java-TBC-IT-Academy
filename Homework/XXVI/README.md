## დავალება 15.08.2022

შექმენით კლასები Address (String country, String city, String street), Person (String firstName, String lastName, java.util.Date birthdate, Address address), University (String name, Address address) და Student extends Person (int course, University university)

1. დაწერეთ განზოგადებული მეთოდი copyObject, რომელსაც გადაეცემა T ტიპის ობიექტი და აბრუნებს მის ასლს T ტიპის ობიექტს. გატესტეთ ეს მეთოდი Student და Person ტიპის კლასებზე.

2. შემდეგ Address ველი Person და University კლასებში გადახდეთ transient და როგორც Serializable, ისე Externalizable ინტერფეისების მეშვეობით გააკეთეთ ისე, რომ კოპირებისას Address ველი არ დაიაკრგოს.

3. Student კლასს შემდეგ დაუმატეთ double gpa ველი და მოახდინეთ მისი სერიალიზაცია ფაილში. შემდეგ შეუცვალეთ კლასის სერიალიზაციის ვერსია და წინათ მიღებული ფაილიდან სცადეთ დესერიალიზაცია. უნდა მიიღოთ შესაბამისი Exception.

4. დაწერეთ T ტიპზე განზოგადებული მეთოდები. პირველს გადაეცემა T ტიპის ობიექტი და ფაილის სრული მისამართი მყარ დისკზე და ამ ფაილში base64-ში სერიალიზებულ ობიექტს წერს. მეორე მეთოდს გადაეცემა მხოლოდ ფაილის სრული მისამართი და T ტიპის ობიექტს აბრუნებს. საჭიროების შემთხვევაში მეთოდებს დამაატეთ არგუმენტ(ებ)ი
