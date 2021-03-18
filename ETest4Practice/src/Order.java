import java.sql.Date;
import java.util.Calendar;

public class Order {
	private int orderID;
	private Item orderedItem;
	private Date orderDate;
	
		public Order (Item orderedItem)
		{
			this.orderedItem = orderedItem;
			orderDate = (Date) Calendar.getInstance().getTime();
		}
		public int getOrderID()
		{
			return orderID;
		}
		public void setOrderID(int orderID)
		{
			this.orderID = orderID;
		}
		public Date getOrderDate()
		{
			return orderDate;
		}
		public void setOrderDate(Date orderDate)
		{
			this.orderDate = orderDate;
		}
		public Item getOrderedItem()
		{
			return orderedItem;
		}
		public void setOrderedItem(Item orderedItem)
		{
		this.orderedItem = orderedItem;
		}
	}
