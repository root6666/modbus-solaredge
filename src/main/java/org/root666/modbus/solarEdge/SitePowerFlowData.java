package org.root666.modbus.solarEdge;

public interface SitePowerFlowData
{  
  boolean isValid();  
  int getGridAcPower(); 
  int getPvAcPower();  
}