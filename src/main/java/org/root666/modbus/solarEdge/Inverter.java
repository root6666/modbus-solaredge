package org.root666.modbus.solarEdge;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.digitalpetri.modbus.master.ModbusTcpMaster;
import com.digitalpetri.modbus.master.ModbusTcpMasterConfig;
import com.digitalpetri.modbus.responses.ReadHoldingRegistersResponse;

import io.netty.buffer.ByteBuf;
import io.netty.util.ReferenceCountUtil;

public class Inverter
{
  ModbusTcpMaster master;
  
  /**
   * just for tests. and Ralf.
   * @return
   */
  public static Inverter buildDefault()
  {
    ModbusTcpMasterConfig config = new ModbusTcpMasterConfig.Builder("192.168.178.41").setPort(502).build();
    ModbusTcpMaster master = new ModbusTcpMaster(config);
    return new Inverter(master);
  }

  public Inverter(ModbusTcpMaster master)
  {
    this.master = master;
  }
  
  public Integer getGridAcPower()
  {
    Integer acPower = null;
    CompletableFuture<ReadHoldingRegistersResponse> future = master.sendRequest(InverterRegisterRequestEnum.M_AC_Power.request(), 1);          
    try
    {
      ReadHoldingRegistersResponse response = future.get();
      acPower = getAsInteger(response);
      ReferenceCountUtil.release(response);
    } catch (InterruptedException | ExecutionException e)
    {
//      e.printStackTrace();
    }
    return acPower ;
  }
  
  public Integer getGridAcPowerSF()
  {
    Integer acPowerSF = null;
    CompletableFuture<ReadHoldingRegistersResponse> future = master.sendRequest(InverterRegisterRequestEnum.M_AC_Power_SF.request(), 1);          
    try
    {
      ReadHoldingRegistersResponse response = future.get();
      acPowerSF = getAsInteger(response);
      ReferenceCountUtil.release(response);
    } catch (InterruptedException | ExecutionException e)
    {
//      e.printStackTrace();
    }
    return acPowerSF ;
  }
  
  public Integer getPvAcPowerSF()
  {
    Integer acPowerSF = null;
    CompletableFuture<ReadHoldingRegistersResponse> future = master.sendRequest(InverterRegisterRequestEnum.I_AC_Power_SF.request(), 1);              
    try
    {
      ReadHoldingRegistersResponse response = future.get();
      acPowerSF = getAsInteger(response);
      ReferenceCountUtil.release(response);
    } catch (InterruptedException | ExecutionException e)
    {
//      e.printStackTrace();
    }
    return acPowerSF ;
  }

  public Integer getPvAcPower()
  {
    Integer acPower = null;
    CompletableFuture<ReadHoldingRegistersResponse> future = master.sendRequest(InverterRegisterRequestEnum.I_AC_Power.request(), 1);          
    try
    {
      ReadHoldingRegistersResponse response = future.get();
      acPower = getAsInteger(response);
      ReferenceCountUtil.release(response);
    } catch (InterruptedException | ExecutionException e)
    {
//      e.printStackTrace();
    }
    return acPower ;
  }

  public I_STATUS getStatus()
  {
    int statusCode = -1;
    CompletableFuture<ReadHoldingRegistersResponse> future = master.sendRequest(InverterRegisterRequestEnum.I_Status.request(), 1);          
    try
    {
      ReadHoldingRegistersResponse response = future.get();
      statusCode = getAsInteger(response);
      ReferenceCountUtil.release(response);
    } catch (InterruptedException | ExecutionException e)
    {
      e.printStackTrace();
    }
    return I_STATUS.get(statusCode) ;
  }

  public String getSpecId()
  {
    String s="";
    CompletableFuture<ReadHoldingRegistersResponse> future = master.sendRequest(InverterRegisterRequestEnum.C_SunSpec_ID.request(), 1);          
    try
    {
      ReadHoldingRegistersResponse response = future.get();
      s = getAsString(response);
      ReferenceCountUtil.release(response);
    } catch (InterruptedException | ExecutionException e)
    {
      e.printStackTrace();
    }
    return s;
  }
  
  public String getManufacturer()
  {
    String s="";
    CompletableFuture<ReadHoldingRegistersResponse> future = master.sendRequest(InverterRegisterRequestEnum.C_Manufacturer.request(), 1);          
    try
    {
      ReadHoldingRegistersResponse response = future.get();
      s = getAsString(response);
      ReferenceCountUtil.release(response);
    } catch (InterruptedException | ExecutionException e)
    {
      e.printStackTrace();
    }
    return s;
  }
  
  
  public String getModel()
  {
    String s="";
    CompletableFuture<ReadHoldingRegistersResponse> future = master.sendRequest(InverterRegisterRequestEnum.C_Model.request(), 1);          
    try
    {
      ReadHoldingRegistersResponse response = future.get();
      s = getAsString(response);
      ReferenceCountUtil.release(response);
    } catch (InterruptedException | ExecutionException e)
    {
      e.printStackTrace();
    }
    return s;
  }
  
  public String getVersion()
  {
    String s="";
    CompletableFuture<ReadHoldingRegistersResponse> future = master.sendRequest(InverterRegisterRequestEnum.C_Version.request(), 1);          
    try
    {
      ReadHoldingRegistersResponse response = future.get();
      s = getAsString(response);
      ReferenceCountUtil.release(response);
    } catch (InterruptedException | ExecutionException e)
    {
      e.printStackTrace();
    }
    return s;
  }
  
  
  public String getSerialNumber()
  {
    String s="";
    CompletableFuture<ReadHoldingRegistersResponse> future = master.sendRequest(InverterRegisterRequestEnum.C_SerialNumber.request(), 1);          
    try
    {
      ReadHoldingRegistersResponse response = future.get();
      s = getAsString(response);
      ReferenceCountUtil.release(response);
    } catch (InterruptedException | ExecutionException e)
    {
      e.printStackTrace();
    }
    return s;
  }
  
  public Integer getFrequency()
  {
    Integer freq = null;
    CompletableFuture<ReadHoldingRegistersResponse> future = master.sendRequest(InverterRegisterRequestEnum.I_AC_Frequency.request(), 1);          
    try
    {
      ReadHoldingRegistersResponse response = future.get();
      freq = getAsInteger(response);
      ReferenceCountUtil.release(response);
    } catch (InterruptedException | ExecutionException e)
    {
      e.printStackTrace();
    }
    return freq ;
  }

  public Integer getFrequencyFactor()
  {
    Integer freqFactor = null;
    CompletableFuture<ReadHoldingRegistersResponse> future = master.sendRequest(InverterRegisterRequestEnum.I_AC_Frequency_SF.request(), 1);          
    try
    {
      ReadHoldingRegistersResponse response = future.get();
      freqFactor = getAsInteger(response);
      ReferenceCountUtil.release(response);
    } catch (InterruptedException | ExecutionException e)
    {
      e.printStackTrace();
    }
    return freqFactor;
  }
 
  
  private static String getAsString(ReadHoldingRegistersResponse response)
  {
    StringBuilder sb_ascii = new StringBuilder();
    ByteBuf registers = response.getRegisters();
    while (registers.isReadable())
    {
      byte b = registers.readByte();
      char c = (char) b;
      sb_ascii.append(c);
    }
    return sb_ascii.toString().trim();
  }
  
  private static int getAsInteger(ReadHoldingRegistersResponse response)
  {
    return response.getRegisters().getShort(0);
  }
 
  public SitePowerFlowData getSitePowerFlow()
  {
    final Integer gridAcPower = getGridAcPower();
    final Integer gridAcPowerSF = getGridAcPowerSF();
    final Integer pvAcPower = getPvAcPower();
    final Integer pvAcPowerSF = getPvAcPowerSF();    
        
    return new SitePowerFlowData()
    {   
      private int scale(int value, int scaleFactor)
      {
        double pow = Math.pow(10, scaleFactor);
        int s = (int)Math.round(value*pow);
        return s;
      }
      @Override
      public boolean isValid()
      {
        return gridAcPower != null && gridAcPowerSF != null && pvAcPower != null && pvAcPowerSF != null;
      }
      
      @Override
      public int getPvAcPower()
      {
        return isValid()?scale(pvAcPower, pvAcPowerSF):-1;
      }
      
      @Override
      public int getGridAcPower()
      {
        return isValid()?scale(gridAcPower, gridAcPowerSF):-1;
      }
    };
  }
  
  public void disconnect()
  {
    CompletableFuture<ModbusTcpMaster> disconnect = master.disconnect();
    try
    {
      disconnect.get();
    } catch (InterruptedException | ExecutionException e)
    {
      e.printStackTrace();
    }
  }
  
}