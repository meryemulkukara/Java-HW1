package Assignment1;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collection;
import java.util.Collections;
//import java.lang.Integer;
import java.io.File; 
import java.io.FileWriter;   // Import the FileWriter class
//import java.io.IOException;
public class Main{


	
    //Reads the file and saves the lines into a String[] array.Then returns it
    public static String[] readFile(String path){
        try {
            int i=0;
            int lenght= Files.readAllLines(Paths.get(path)).size();
            String[] results = new String[lenght];
            for (String line : Files.readAllLines(Paths.get(path))) {
                results[i++]=line;
            }

            return results;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //READ_AUTHOR method split line and call add_author method
    public static void readAuthor(String line, ArrayList<Author>Authors)
    {
        String[] authorArray=new String[11];
        String [] authorArr=line.split(" ");
        int i=authorArr.length;
        for(int j=0;j<11;j++)
        {
        	if(j<i)
        		authorArray[j]=authorArr[j];
        	else
        		authorArray[j]=null;
        }
        
        add_author(authorArray[1],authorArray[2],authorArray[3],authorArray[4],authorArray[5],authorArray[6],authorArray[7],authorArray[8],authorArray[9],authorArray[10],Authors);

    }
    
    //ADD_AUTHOR method add line by line id,name,university,departmen,email vs  information to Author obj
    public static void add_author(String id,String name,String university,String department,String email,String article1,String article2,String article3,String article4,String article5,ArrayList<Author>Authors)
    {   
        Authors.add(new Author(id,name,university,department,email,article1,article2,article3,article4,article5));
    }
    
    public static void read_command_txt(String[] line_arr,ArrayList<Article>Articles,ArrayList<Author>Authors)
    {
    	try {
            File file = new File("output.txt");
            if (file.createNewFile()) {
              //System.out.println("File created: " + file.getName());
            } else {
              //System.out.println("File already exists.");
            }
            
            FileWriter writer = new FileWriter(file);
            for(String line :line_arr)
            {
            	String[] commandArr=line.split(" ");
            	
            	String read1="read";
            	String list_command="list";
            	String completeAll_command="completeAll";
            	String sortedAll_command="sortedAll";
            	String del_command="del";
            	
            	if(commandArr[0].equals(read1))//control read author.txt command
            	{	
        			String []lines_article=readFile(commandArr[1]);
        			for(String lines:lines_article) 
        				readArticle(lines,Articles);
            	}
            	else {
            		if(commandArr[0].equals(list_command))//control read author.txt command
                	{	writer.write("-----------------------------------------------------------------List------------------------------------------------------------------------------ \n ");
                	}
                		 
                	if(commandArr[0].equals(completeAll_command))
                	{	
                		completeAll(Authors,Articles);
                    	writer.write("***********************************************Complete All Succesful************************************************************* \n");
                    	writer.write("-----------------------------------------------------------------List------------------------------------------------------------------------------ \n ");
                    	
                	}
                	if(commandArr[0].equals(sortedAll_command))
                	{
                		sortedAll(Authors);
                		writer.write("***********************************************Sorted All Succesful************************************************************* \n \n");
                		writer.write("-----------------------------------------------------------------List------------------------------------------------------------------------------ \n ");
                    	
                	}
                	if(commandArr[0].equals(del_command))
                	{
                		del(commandArr[1],Authors);
                		writer.write("***********************************************Del Succesful************************************************************* \n \n");
                		writer.write("-----------------------------------------------------------------List------------------------------------------------------------------------------ \n ");
                	}
                	for(Author author:Authors)
            		{
            			writer.write("Author:"+author.getId()+"\t"+author.getName()+"\t"+author.getUniversity()+"\t"+author.getDepartment()+"\t"+author.getEmail()+" "+"\n");
            		
            			for(Article article1:Articles)
            			{   
            				if(article1.getPaperid()!=null&&(article1.getPaperid()).equals(author.getArticle1()))
            				{ 	
            					writer.write("+"+article1.getPaperid() +"\t"+ article1.getName() +"\t"+ article1.getPublisherName()+"\t"+ article1.getPublishYear()+ "\n");
            				  	for(Article article2:Articles)
            				  	{	if(article2.getPaperid()!=null&&(article2.getPaperid()).equals(author.getArticle2()))
            			  			{ 
            			  				writer.write("+"+article2.getPaperid() +"\t"+ article2.getName() +"\t"+ article2.getPublisherName()+"\t"+ article2.getPublishYear()+ "\n");
            			  				for(Article article3:Articles)
            			  				{
            			  					if(article3.getPaperid()!=null&&(article3.getPaperid()).equals(author.getArticle3()))
            			  					{ 
            			  						writer.write("+"+article3.getPaperid() +"\t"+ article3.getName() +"\t"+ article3.getPublisherName()+"\t"+ article3.getPublishYear()+ "\n");
            			  						for(Article article4:Articles)
            			  						{
            			  							if(article4.getPaperid()!=null&&(article4.getPaperid()).equals(author.getArticle4()))
                    			  					{ 
                    			  						writer.write("+"+article4.getPaperid() +"\t"+ article4.getName() +"\t"+ article4.getPublisherName()+"\t"+ article4.getPublishYear()+ "\n");
                    			  						for(Article article5:Articles)
                    			  						{
                    			  							if(article5.getPaperid()!=null&&(article5.getPaperid()).equals(author.getArticle5()))
                            			  					{ 
                            			  						writer.write("+"+article5.getPaperid() +"\t"+ article5.getName() +"\t"+ article5.getPublisherName()+"\t"+ article5.getPublishYear()+ "\n   \n");
                            			  					}
                    			  						}
                    			  					}
            			  						}
            			  					}
            			  				}
            			  			}
            				  	}	
            			  } 	
            		} } writer.write("-----------------------------------------------------------End---------------------------------------------------------------------- \n \n");
        	}
        	
            }         
    	    writer.close();
               
             
    	}catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
    
    //Complete All commands complete all authors
    public static void completeAll(ArrayList<Author>Authors,ArrayList<Article>Articles)
    {
    	//first control all articles null or not 
    	//if articles is null, articles with the same ID as autohorID are found.
    	for(Author author:Authors)
		{
    		if((author.getArticle5())==null)
    		{
    			if((author.getArticle4())==null)
    			{
    				if((author.getArticle3())==null)
    				{
    					if((author.getArticle2())==null)
    					{
    						if((author.getArticle1())==null)
    						{
    							String authorId=author.getId();
    							for(Article article1:Articles)
    							{
    								String articleId=(article1.getPaperid()).substring(0, 3);
    								if(authorId.equals(articleId))
    								{
    									author.setArticle1(article1.getPaperid());
    								}
    		    				}
    						}	
    						 String authorId=author.getId();
    						for(Article article2:Articles)
    						{
    							String articleId=(article2.getPaperid()).substring(0, 3);
    							if(authorId.equals(articleId)&&(!((author.getArticle1()).equals(article2.getPaperid()))))
    								author.setArticle2(article2.getPaperid());
    						}	
    					}
    					
    					String authorId=author.getId();
    					for(Article article3:Articles)
    					{
    						String articleId=(article3.getPaperid()).substring(0, 3);
    						if(authorId.equals(articleId)&&(!((author.getArticle1()).equals(article3.getPaperid())))&&(!((author.getArticle2()).equals(article3.getPaperid()))))
    							author.setArticle3(article3.getPaperid());
    					}
    				}
    				String authorId=author.getId();
    				for(Article article4:Articles)
    				{
    					String articleId=(article4.getPaperid()).substring(0, 3);
    					if(authorId.equals(articleId)&&(!((author.getArticle1()).equals(article4.getPaperid())))&&(!((author.getArticle2()).equals(article4.getPaperid())))&&(!((author.getArticle3()).equals(article4.getPaperid())))&&(author.getArticle4()==null))
    					{
    						author.setArticle4(article4.getPaperid());
    					}
    				}
    			}	
 
    			String authorId=author.getId();
    			for(Article article5:Articles)
    			{
    				String articleId=(article5.getPaperid()).substring(0, 3);
    				if(authorId.equals(articleId)&&(!((author.getArticle1()).equals(article5.getPaperid())))&&(!((author.getArticle2()).equals(article5.getPaperid())))&&(!((author.getArticle3()).equals(article5.getPaperid())))&&(!((author.getArticle4()).equals(article5.getPaperid()))))
    				{
    					author.setArticle5(article5.getPaperid());
    				}
    			}
    		}			
    	}
	}
   
    //SORTED ALL command sorting author articles
    public static void sortedAll(ArrayList<Author>Authors)
    {
    	for(Author a:Authors)//Authors list
    	{
    		ArrayList<String> articleArr=new ArrayList<>();
    		if(a.getArticle1()!=null)//if getArticle1 is not null add article arr , article1
    		{
    			articleArr.add(a.getArticle1());
    			if(a.getArticle2()!=null)//if getArticle2 is not null add article arr , article2
    			{
    				articleArr.add(a.getArticle2());
    				if(a.getArticle3()!=null)//if getArticle3 is not null add article arr , article3
    				{
        				articleArr.add(a.getArticle3());
        				if(a.getArticle4()!=null)//if getArticle4 is not null add article arr , article4
        				{
            				articleArr.add(a.getArticle4());
            				if(a.getArticle5()!=null)//if getArticle5 is not null add article arr , article5
            				{
                				articleArr.add(a.getArticle5());
                			}
            			}
        			}
    			}
    		}
    		    		   		
    		Collections.sort(articleArr);
    		int length=articleArr.size();
    		if(length==5)//if all articles is not null
    		{
    			a.setArticle1(articleArr.get(0));
    			a.setArticle2(articleArr.get(1));
    			a.setArticle3(articleArr.get(2));
    			a.setArticle4(articleArr.get(3));
    			a.setArticle5(articleArr.get(4));
    		}
    		if(length==4)//if 4 articles is not null
    		{
    			a.setArticle1(articleArr.get(0));
    			a.setArticle2(articleArr.get(1));
    			a.setArticle3(articleArr.get(2));
    			a.setArticle4(articleArr.get(3));
    			a.setArticle5(null);
    		}
    		if(length==3)//if 3 articles is not null
    		{
    			a.setArticle1(articleArr.get(0));
    			a.setArticle2(articleArr.get(1));
    			a.setArticle3(articleArr.get(2));
    			a.setArticle4(null);
    			a.setArticle5(null);
    		}
    		if(length==2)//if 2 articles is not null
    		{
    			a.setArticle1(articleArr.get(0));
    			a.setArticle2(articleArr.get(1));
    			a.setArticle3(null);
    			a.setArticle4(null);
    			a.setArticle5(null);
    		}
    		if(length==1)//if 1 articles is not null
    		{
    			a.setArticle1(articleArr.get(0));
    			a.setArticle2(null);
    			a.setArticle3(null);
    			a.setArticle4(null);
    			a.setArticle5(null);
    		}
    	}
    }
    
    //DEL COMMAND
    public static void del(String id,ArrayList<Author>Authors)
    {
    	
    	for (int i = 0; i < Authors.size(); i++)
    	{
    		if((Authors.get(i)).getId().equals(id))//Find the object for deleting
    		{
    			Authors.remove(i);  		}
    	}    	
    }
    
    
    //READ_ARTICLE method split line and call add_article method
     public static void readArticle(String line, ArrayList<Article>Articles)
    {
    	String[] articleArr=line.split(" ");
    	add_article(articleArr[1],articleArr[2],articleArr[3],articleArr[4],Articles);
    }
    
    //ADD_ARTICLE method add line by line paperid,name,publisherName,publishYear  information to Article obj
    public static void add_article(String paperid, String name, String publisherName, String publishYear,ArrayList<Article>Articles)
    {
    	Articles.add(new Article(paperid,name,publisherName,publishYear));
    }
    
    
    public static void main(String [] args){
        ArrayList<Author>authors=new ArrayList<>();
        ArrayList<Article>articles=new ArrayList<>();
        
        String[] lines_author=readFile(args[0]);//read author.txt
        for(String line:lines_author)
        {   
        	readAuthor(line,authors);   }
        String[] lines_command=readFile(args[1]);//read command.txt
        read_command_txt(lines_command,articles,authors);
    }
}


