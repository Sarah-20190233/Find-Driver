package software2;

import java.util.ArrayList;

public class Ride {

    private String Source;
    private String Destination;
    private double Price;
    
    ArrayList<String> list_sources = new ArrayList<String>();
   
    public Ride()
    {
        this.Source = "";
        this.Destination = "";
        this.Price = 0;
    }
    
    public double show_offer() {
    //	Driver d;
    //	d.set_offer;
    	return 0;
    }
	
	public String getSource() {
		return Source;
	}

	public void setSource(String source) {
		Source = source;
	}

	public String getDestination() {
		return Destination;
	}

	public void setDestination(String destination) {
		Destination = destination;
	}
        
        public void List_Sources(String source)
        {
            list_sources.add(source);
          
        }

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}



}

