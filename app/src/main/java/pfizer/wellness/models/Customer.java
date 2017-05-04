package pfizer.wellness.models;

/**
 * Created by ROEL on 4/19/2017.
 */

public class Customer
{

    //private variables
    int _id;
    String _uid;
    String _name;
    String _gender;
    String _dateOfBirth;
    String _preExistingConditions;

    //empty constructor
    public Customer(){

    }

    //constructor
    public Customer( int id, String uid, String name, String _gender, String _dateOfBirth, String _preExistingConditions ){
        this._id = id;
        this._name = name;
        this._gender = _gender;
        this._dateOfBirth = _dateOfBirth;
        this._preExistingConditions = _preExistingConditions;
    }

    //constructor
    public Customer(String name, String _gender, String _dateOfBirth, String _preExistingConditions){
        this._name = name;
        this._gender = _gender;
        this._dateOfBirth = _dateOfBirth;
        this._preExistingConditions = _preExistingConditions;
    }

    //getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    //getting ID
    public String getUID(){
        return this._uid;
    }

    // setting id
    public void setUID(String uid){
        this._uid = uid;
    }

    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }

    // getting gender
    public String getGender(){
        return this._gender;
    }

    // setting gender
    public void setGender(String gender){
        this._gender = gender;
    }

    // getting date of birth
    public String getDateOfBirth(){
        return this._dateOfBirth;
    }

    // setting date of birth
    public void setDateOfBirth(String dateOfBirth){
        this._dateOfBirth = dateOfBirth;
    }

    // getting date of birth
    public String getPreExistingConditions(){
        return this._preExistingConditions;
    }

    // setting date of birth
    public void setPreExistingConditions(String preExistingConditions){
        this._dateOfBirth = preExistingConditions;
    }

}
