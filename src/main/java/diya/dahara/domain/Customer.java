/*
*  (C) Copyright 2010-2013 hSenid Mobile Solutions (Pvt) Limited.
*  All Rights Reserved.
*
*  These materials are unpublished, proprietary, confidential source code of
*  hSenid Mobile Solutions (Pvt) Limited and constitute a TRADE SECRET
*  of hSenid Mobile Solutions (Pvt) Limited.
*
*  hSenid Mobile Solutions (Pvt) Limited retains all title to and intellectual
*  property rights in these materials.
*/
package diya.dahara.domain;


public interface Customer {
    String getId();

    String getNic();

    String getName();

    String getEmail();

    String getTelephone();

    String getCountry();

    String getRoomId();

    String getFoodId();

    String getTableId();

    String getTourId();

    String getTransportId();
}
