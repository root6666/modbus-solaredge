package org.root666.modbus.solarEdge;

import com.digitalpetri.modbus.requests.ReadHoldingRegistersRequest;

public enum InverterRegisterRequestEnum
{
  C_SunSpec_ID(new ReadHoldingRegistersRequest(40000, 2)),
  C_Manufacturer(new ReadHoldingRegistersRequest(40004, 16)), 
  C_Model(new ReadHoldingRegistersRequest(40020, 16)), 
  C_Version(new ReadHoldingRegistersRequest(40044, 8)), 
  C_SerialNumber( new ReadHoldingRegistersRequest(40052, 16)), 
  I_AC_Frequency(new ReadHoldingRegistersRequest(40085, 1)), 
  I_AC_Frequency_SF(new ReadHoldingRegistersRequest(40086, 1)), 
  I_Status(new ReadHoldingRegistersRequest(40107, 1)), 
  I_AC_Power(new ReadHoldingRegistersRequest(40083, 1)),
  I_AC_Power_SF(new ReadHoldingRegistersRequest(40084, 1)),
  M_AC_Power(new ReadHoldingRegistersRequest(40206, 1)),
  M_AC_Power_SF(new ReadHoldingRegistersRequest(40210, 1));  

  ReadHoldingRegistersRequest r;

  InverterRegisterRequestEnum(ReadHoldingRegistersRequest r)
  {
    this.r = r;
  }

  public ReadHoldingRegistersRequest request()
  {
    return r;
  }
  
}