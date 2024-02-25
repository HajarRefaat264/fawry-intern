package org.entities;

import lombok.Data;

import java.util.Date;

@Data
public class Branches {
    Zones zones_id;
    String branch_name;
    String building_number;
    String branch_street_name;
    Date branch_working_start;
    Date branch_working_end;
    String branch_telephone;
    int id;






}
