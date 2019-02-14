Libray MHPermission Easy use of permission

[![](https://jitpack.io/v/io.github.mohammad0261/MHPermission.svg)](https://jitpack.io/#io.github.mohammad0261/MHPermission)

Use MHPermssion into build.gradle


allprojects

{
    repositories 
    
{
        google()
        jcenter()
        maven { url 'https://jitpack.io'
        
        }
    }
}

dependencies

{

implementation 'io.github.mohammad0261:MHPermission:1.02'

}


1.use ManagerPermission into Project

private lateinit var manager: ManagerPermission

2. use Access Permission

 val e: String = RequestHelper().ACCESS_COARSE_LOCATION
 
3.call method onRequestPermissionsResult



public class MainActivity : AppCompatActivity()

{

 private lateinit var manager: ManagerPermission
 val e: String = RequestHelper().ACCESS_COARSE_LOCATION
override fun onCreate(savedInstanceState: Bundle?)

{
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn.setOnClickListener { btn ->
            manager = ManagerPermission(this, listOf(e), Requester)
            manager.checkpermission()
            
        }
        
    }

override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) 
    
    {
            Requester ->
            
    {
                val ispermissionGrand= manager.processPermissionsResult(requestCode, permissions, grantResults)
                if (ispermissionGrand)
                
                {
                    // Do the task now
                    Toast.makeText(this@MainActivity, "Permissions granted.", Toast.LENGTH_SHORT).show()
                    
                }
                  else
    
                {
                    Toast.makeText(this@MainActivity, "Permissions denied.", Toast.LENGTH_SHORT).show()
                    
                }
                
            }
            
        }
        
    }
    
}
