package pojo;

import java.util.Date;


public class CustomerObject {
    private int id;
    private String lastName;
    private String firstName;
    private String address;
    private String type;
    private Date collectionDate;
    private String description;
    private float waist;
    private float hip;
    private float shoulder;
    private float bust;
    private float blouse;
    private float skirtLength;
    private float gownLength;
    private float acrossBack;
    private float underBust;
    private float shoulderToWaist;
    private float bp;
    private float np;

    public CustomerObject(
            int id,
            String lastName,
            String firstName,
            String address,
            String type,
            Date collectionDate,
            String description,
            float waist,
            float hip,
            float shoulder,
            float bust,
            float blouse,
            float skirtLength,
            float gownLength,
            float acrossBack,
            float underBust,
            float shoulderToWaist,
            float bp,
            float np
    ) {
        super();
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.type = type;
        this.collectionDate = collectionDate;
        this.description = description;
        this.waist = waist;
        this.hip = hip;
        this.shoulder = shoulder;
        this.bust = bust;
        this.blouse = blouse;
        this.skirtLength = skirtLength;
        this.gownLength = gownLength;
        this.acrossBack = acrossBack;
        this.underBust = underBust;
        this.shoulderToWaist = shoulderToWaist;
        this.bp = bp;
        this.np = np;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return collectionDate;
    }

    public void setDate(Date collectionDay) {
        this.collectionDate = collectionDay;
    }

    public float getShoulder() {
        return shoulder;
    }

    public void setShoulder(float shoulder) {
        this.shoulder = shoulder;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getWaist() {
        return waist;
    }

    public void setWaist(float waist) {
        this.waist = waist;
    }

    public float getHip() {
        return hip;
    }

    public void setHip(float hip) {
        this.hip = hip;
    }

    public float getBust() {
        return bust;
    }

    public void setBust(float bust) {
        this.bust = bust;
    }

    public float getBlouse() {
        return blouse;
    }

    public void setBlouse(float blouse) {
        this.blouse = blouse;
    }

    public float getSkirtLength() {
        return skirtLength;
    }

    public void setSkirtLength(float skirtLength) { this.skirtLength = skirtLength; }

    public float getGownLength() {
        return gownLength;
    }

    public void setGownLength(float gownLength) { this.gownLength = gownLength; }

    public float getShoulderToWaist() {
        return shoulderToWaist;
    }

    public void setShoulderToWaist(float shoulderToWaist) {
        this.shoulderToWaist = shoulderToWaist;
    }

    public float getAcrossBack() {
        return acrossBack;
    }

    public void setAcrossBack(float acrossBack) {
        this.acrossBack = acrossBack;
    }

    public float getUnderBust() {
        return underBust;
    }

    public void setUnderBust(float underBust) { this.underBust = underBust; }

    public float getbp() {
        return bp;
    }

    public void setbp(float bp) {
        this.bp = bp;
    }

    public float getnp() {
        return np;
    }

    public void setnp(float np) {
        this.np = np;
    }


    @Override
    public String toString() {
        return String.format(
                "Customer [" +
                        "id=%s, "
                        + "LastName=%s,"
                        + "FirstName=%s, "
                        + "Address = %s, "
                        + "Type = %s"
                        + "Collection DAy = %s"
                        + "Description = %s"
                        + "Waist = %s"
                        + "Hip = %s"
                        + "Shoulder = %s"
                        + "Bust = %s"
                        + "Skirt Length = %s"
                        + "Gown Length = %s"
                        + "ShoulderTowaist = %s"
                        + "Across Back = %s"
                        + "Blouse =%s"
                        + "UnderBust = %s"
                        + "BP = %s"
                        + "NP = %s"
                        + "]",
                id,
                lastName,
                firstName,
                address,
                type,
                collectionDate,
                description,
                waist,
                hip,
                shoulder,
                bust,
                skirtLength,
                gownLength,
                shoulderToWaist,
                acrossBack,
                blouse,
                underBust,
                bp,
                np
        );
    }

}
