        package com.example.JPAApplication.Entity;

        import javax.persistence.*;

        @Entity
        public class Subjects {

                @Id
                @GeneratedValue(strategy = GenerationType.AUTO)
                private int sub_id;
                @OneToOne
                @JoinColumn(name = "author_id")
                private Author author;


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

        public Author getAuthor() {
            return author;
        }

        public void setAuthor(Author author) {
            this.author = author;
        }

        }
