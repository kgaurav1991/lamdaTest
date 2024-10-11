package SeleniumMaven.SeleniumMaven;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	Naukri_Login n = new Naukri_Login();
    	n.beforeMethod();
    	n.openUrl();
    }
}
