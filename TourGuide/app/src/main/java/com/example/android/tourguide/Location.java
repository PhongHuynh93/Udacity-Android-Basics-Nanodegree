package com.example.android.tourguide;

/**
 * {@link Location} represents a location that the user may want to visit.
 * It contains resource IDs for the name, address, and
 * optional image file for that location.
 */
public class Location {
    /** String resource ID for the Name of location */
    private int mNameId;

    /** String resource ID for the address of location */
    private int mAddressId;

    /** Image resource ID for the location */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this location */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Location object
     * @param nameId
     * @param addressId
     */
    public Location(int nameId, int addressId){
        mNameId = nameId;
        mAddressId = addressId;
    }

    /**
     * Create a new Location object with an image
     * @param nameId
     * @param addressId
     * @param imageResourceId
     */
    public Location(int nameId, int addressId, int imageResourceId){
        mNameId = nameId;
        mAddressId = addressId;
        mImageResourceId = imageResourceId;
    }

    public int getNameId(){
        return mNameId;
    }

    public int getAddressId(){
        return mAddressId;
    }

    public int getImageResourceId(){
        return mImageResourceId;
    }

    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}
