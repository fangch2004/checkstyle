////////////////////////////////////////////////////////////////////////////////
// Test case file for checkstyle.
// Created: 2002
////////////////////////////////////////////////////////////////////////////////

/**
 * Test case for hidden fields
 * @author Rick Giles
 **/
class InputHiddenField
{
    private int hidden = 0;
    
    public InputHiddenField()
    {
        int hidden = 0; //shadows field
    }
    
    public InputHiddenField(int hidden) //parameter shadows field
    {
    }
    
    public void shadow()
    {
        int hidden = 0; //shadows field
    }
    
    public void shadowFor()
    {
        for (int hidden = 0; hidden < 1; hidden++) { //shadows field
        }
    }
    
    public void shadowParam(int hidden) //parameter shadows field
    {
    }
    
    public class Inner
    {
        private int innerHidden = 0;
        
        public Inner()
        {
            int innerHidden = 0; //shadows field
        }
    
        public Inner(int innerHidden) //shadows field
        {
        }
        
        private void innerShadow()
        {
            int innerHidden = 0; //shadows inner field
            int hidden = 0; //shadows outer field
        }
        
        private void innerShadowFor()
        {
            for (int innerHidden = 0; innerHidden < 1; innerHidden++) {
            }
            //shadows outer field
            for (int hidden = 0; hidden < 1; hidden++) {
            }
        }
        
        private void shadowParam(
            int innerHidden, //parameter shadows inner field
            int hidden //parameter shadows outer field
        )
        {
        }
        
        {
            int innerHidden = 0;//shadows inner field
            int hidden = 0; //shadows outer field
        }
    }

    {
        int hidden = 0;//shadows field
    }       
}
    
interface NothingHidden
{
    public static int notHidden = 0;
    
    // not an error
    public void noShadow(int notHidden);
}
