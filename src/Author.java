package Assignment1;
public class Author {

    private String id;
    private String name;
    private String university;
    private String department;
    private String email;
    private String article1;
    private String article2;
    private String article3;
    private String article4;
    private String article5;

    public Author(String id,String name,String university,String department,String email,
                  String article1,String article2,String article3,String article4,String article5)
    {
        this.id = id;
        this.name=name;
        this.university=university;
        this.department=department;
        this.email=email;
        this.article1=article1;
        this.article2=article2;
        this.article3=article3;
        this.article4=article4;
        this.article5=article5;
    }

    public String getName() { return name;    }
    public void setName(String name) { this.name = name;    }

    public String getId() { return id;    }
    public void setId(String id) { this.id = id;    }

    public String getUniversity() { return university;    }
    public void setUniversity(String university) { this.university = university;    }

    public String getDepartment() { return department;    }
    public void setDepartment(String department) { this.department = department;    }

    public String getEmail() { return email;    }
    public void setEmail(String email) { this.email = email;    }

    public String getArticle1() { return article1;    }
    public void setArticle1(String article1) { this.article1 = article1;    }

    public String getArticle2() { return article2;    }
    public void setArticle2(String article2) { this.article2 = article2;    }

    public String getArticle3() { return article3;    }
    public void setArticle3(String article3) { this.article3 = article3;    }

    public String getArticle4() { return article4;    }
    public void setArticle4(String article4) { this.article4 = article4;    }

    public String getArticle5() { return article5;    }
    public void setArticle5(String article5) { this.article5 = article5;    }
}


