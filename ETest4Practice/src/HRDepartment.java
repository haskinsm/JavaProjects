import java.util.*; 

//ETEST 2018, practice for 2019.
public class HRDepartment {

	public ArrayList< Employee > employeeList = new ArrayList<>();
	
	public void addEmployee( int employeeId, String name, int role)
	{
		Employee a = new Employee( employeeId, name, role);
		employeeList.add( a );
	}
	public void printAllEmployees()
	{
		for( int i = 0; i < employeeList.size(); i++)
		{
			Employee a = employeeList.get( i );
			System.out.println( a.toString() );
		}
	}
	public Employee findEmployee( int employeeId )
	{
		for( int i = 0; i < employeeList.size(); i++)
		{
			Employee a = employeeList.get( i );
			if( a.getEmployeeId() == employeeId)
			{
				return a;
			}
		}
		return null; //if no matching employee id found
	}
	public boolean recordEmployeeAppraisal( int employeeId, Date appraisalDate, int score)
	{
		Employee a = findEmployee( employeeId );
		if( a != null)
		{
			EmployeeAppraisal b = new EmployeeAppraisal( appraisalDate, score);
			a.getAppraisalHistory().add(b);
			return true;
		}
		return false;
	}
	public boolean promoteEmployee( int employeeId )
	{
		Employee a = findEmployee( employeeId );
		if( a != null)
		{
			int size = a.getAppraisalHistory().size();
			if( size >= HRCodes.MIN_APPRAISALS)
			{
				EmployeeAppraisal b = a.getAppraisalHistory().get( size - 1 );
				EmployeeAppraisal c = a.getAppraisalHistory().get( size - 2 );
				if( b.getAppraisalScore() == HRCodes.EXCEEDED_EXPECTATIONS && c.getAppraisalScore() == HRCodes.EXCEEDED_EXPECTATIONS)
				{
					
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(new Date());
					Date currentDate = calendar.getTime();
					Date promotionDate = a.getPromotionDate();
				    calendar.add(Calendar.YEAR,-1);   
				    Date lastYearsDate = calendar.getTime(); //Problem with Dates here not sure how to fix, rest of program is grand
					if (promotionDate.after( lastYearsDate ) )
					{
						int newRoleNumber = a.getRole() - 1;
						if( newRoleNumber >= 0)
						{
							a.setRole( newRoleNumber );
							a.setPromotionDate( currentDate );
							return true;
						}
					}
				}
			}
		}
		return false;
	}

}
