        package com.example.JPAApplication.Entity;

        import javax.persistence.*;
        import java.util.Set;

        @Entity
        public class Subjects {

                @Id
                @GeneratedValue(strategy = GenerationType.AUTO)
                private int sub_id;

                @ManyToMany(mappedBy = "subjects")
                private Set<Author> author;

                public Set<Author> getAuthor() {
                        return author;
                }

                public void setAuthor(Set<Author> author) {
                        this.author = author;
                }

                private String subjectName;

                public int getSub_id() {
                        return sub_id;
                }

                public void setSub_id(int sub_id) {
                        this.sub_id = sub_id;
                }

                public String getSubjectName() {
                        return subjectName;
                }

                public void setSubjectName(String subjectName) {
                        this.subjectName = subjectName;
                }


        }
