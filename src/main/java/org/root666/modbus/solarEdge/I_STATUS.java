package org.root666.modbus.solarEdge;

public enum I_STATUS
{
  I_STATUS_OFF, I_STATUS_SLEEPING, I_STATUS_MPPT, I_STATUS_IVALID;

  public static I_STATUS get(int statusCode)
  {
    I_STATUS s = I_STATUS.I_STATUS_IVALID;
    if (statusCode == 1)
      s = I_STATUS_OFF;
    else if (statusCode == 2)
      s = I_STATUS_SLEEPING;
    else if (statusCode == 4)
      s = I_STATUS_MPPT;
    return s;
  }
}