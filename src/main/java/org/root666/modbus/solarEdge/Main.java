package org.root666.modbus.solarEdge;

import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.digitalpetri.modbus.master.ModbusTcpMaster;
import com.digitalpetri.modbus.master.ModbusTcpMasterConfig;

public class Main
{

  private static final Logger logger = LoggerFactory.getLogger(Main.class);
  

  public static void main(String[] args) throws InterruptedException
  {
    
    ModbusTcpMasterConfig config = new ModbusTcpMasterConfig.Builder("192.168.178.41").setPort(502).build();
    ModbusTcpMaster master = new ModbusTcpMaster(config);    

    final Inverter i = new Inverter(master);
    logger.info("SunSpecId: {}, Manufacturer: {}, Model: {}, Version: {}, SerialNumber: {}",i.getSpecId(), i.getManufacturer(), i.getModel(),i.getVersion(),i.getSerialNumber());
    logger.info("Frequency: {}, Factor: {}",i.getFrequency(), i.getFrequencyFactor());
    
    
    Timer t = new Timer();
    t.schedule(new TimerTask()
    {
      @Override
      public void run()
      {
                
        SitePowerFlowData data = i.getSitePowerFlow();
        if (data.isValid())
        {
          int pvAcPower = data.getPvAcPower();
          int loadAcPower = data.getGridAcPower();
          int siteLoad = pvAcPower - loadAcPower;
          String direction = loadAcPower > 0 ? ">>" : "<<";
          loadAcPower = Math.abs(loadAcPower);
          logger.info("production: {} >> consumption: {} {} grid: {}", pvAcPower, siteLoad, direction, loadAcPower);          
        }
        else         
          logger.info("empty call...");
//        master.disconnect();
      }
    }, 1, 3000); 
      
  }
  
  
}

