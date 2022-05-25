package com.globant.got.client.model;

import lombok.Data;

@Data
public class GoTCharacter {

    String url;             //The hypermedia URL of this resource
    String name;            //The name of this character
    String gender;          //The gender of this character.
    String culture;         //The culture that this character belongs to.
    String born;            //Textual representation of when and where this character was born.
    String died;            //Textual representation of when and where this character died.
    String[] titles;        //The titles that this character holds.
    String[] aliases;       //The aliases that this character goes by.
    String father;          //The character resource URL of this character's father.
    String mother;          //The character resource URL of this character's mother.
    String spouse;          //An array of Character resource URLs that has had a POV-chapter in this book.
    String[] allegiances;   //An array of House resource URLs that this character is loyal to.
    String[] books;         //An array of Book resource URLs that this character has been in.
    String[] povBooks;      //An array of Book resource URLs that this character has had a POV-chapter in.
    String[] tvSeries;      //An array of names of the seasons of Game of Thrones that this character has been in.
    String[] playedBy;      //An array of actor names that has played this character in the TV show Game Of Thrones.
}
