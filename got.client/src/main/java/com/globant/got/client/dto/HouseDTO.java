package com.globant.got.client.dto;

import lombok.Data;

@Data
public class HouseDTO {

    String url;                //The hypermedia URL of this resource
    String name;               //The name of this house
    String region;             //The region that this house resides in.
    String coatOfArms;         //Text describing the coat of arms of this house.
    String words;              //The words of this house.
    String[] titles;           //The titles that this house holds.
    String[] seats;            //The seats that this house holds.
    String currentLord;        //The Character resource URL of this house's current lord.
    String heir;               //The Character resource URL of this house's heir.
    String overlord;           //The House resource URL that this house answers to.
    String founded;            //The year that this house was founded.
    String founder;            //The Character resource URL that founded this house.
    String diedOut;            //The year that this house died out.
    String[] ancestralWeapons; //An array of names of the noteworthy weapons that this house owns.
    String[] cadetBranches;    //An array of House resource URLs that was founded from this house.
    String[] swornMembers;     //An array of Character resource URLs that are sworn to this house.
}
