package org.mort11.commands.ee;

import org.mort11.util.EndEffectorConstants;

public class Prime extends SetCAMAngle
{

    public Prime()
    {
        super(EndEffectorConstants.CAM_PRIMED_DEG.get());

    }
    
    protected void execute(){
        super.execute();
        if(onTarget()){
            catapult.setPrimed(true);
        }
    }
}
