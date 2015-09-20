package ru.loginet.test.cola;


public class ShippingRequestValueContainerCola {
    public static String file_path = "src/test/testFiles/ColaValid1.xls";
    private String od;                   //   c
    private String requestDate;              //   D
    private String requestTime;              //   E
    private String loadStoreCode;           //   F
    private String dateUnload;            //   G
    private String timeUnload;            //   F
    private String unloadStoreCode;           //   I
    private String requestService;           //   J
    private String vehicleType;           //   K
    private String bodySpace;             //   L
    private String load;                  //   M
    private String weight;                //   N
    private String tripTypes;             //   O
    private String region;                //   P
    private String requestTotalCargoCost;                  //   R
    private String comment;               //   S
    private String price;                 //   T

    private String adressLoad;
    private String adressUnload;

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    private String requestName;


    public String getAdressUnload() {
        return adressUnload;
    }

    public void setAdressUnload(String adressUnload) {
        this.adressUnload = adressUnload;
    }


    public String getAdressLoad() {
        return adressLoad;
    }

    public void setAdressLoad(String adressLoad) {
        this.adressLoad = adressLoad;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setOd(String od) {
        this.od = od;
    }

    public String getOD() {
        return od;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setLoadStoreCode(String loadStoreCode) {
        this.loadStoreCode = loadStoreCode;
    }

    public String getLoadStoreCode() {
        return loadStoreCode;
    }

    public void setDateUnload(String dateUnload) {
        this.dateUnload = dateUnload;
    }

    public String getDateUnload() {
        return dateUnload;
    }

    public void setTimeUnload(String timeUnload) {
        this.timeUnload = timeUnload;
    }

    public String getTimeUnload() {
        return timeUnload;
    }

    public void setUnloadStoreCode(String unloadStoreCode) {
        this.unloadStoreCode = unloadStoreCode;
    }

    public String getUnloadStoreCode() {
        return unloadStoreCode;
    }

    public void setRequestService(String requestService) {
        this.requestService = requestService;
    }

    public String getRequestService() {
        return requestService;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setBodySpace(String bodySpace) {
        this.bodySpace = bodySpace;
    }

    public String getBodySpace() {
        return bodySpace;
    }

    public void setLoad(String load) {
        this.load = load;
    }

    public String getLoad() {
        return load;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWeight() {
        return weight;
    }

    public void setTripTypes(String tripTypes) {
        this.tripTypes = tripTypes;
    }

    public String getTripTypes() {
        return tripTypes;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setRequestTotalCargoCost(String requestTotalCargoCost) {
        this.requestTotalCargoCost = requestTotalCargoCost;
    }

    public String getRequestTotalCargoCost() {
        return requestTotalCargoCost;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }
}
