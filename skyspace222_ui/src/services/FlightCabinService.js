import http from "../http-common"; 

class FlightCabinService {
  getAllFlightCabins(searchDTO) {
    console.log(searchDTO)
    return this.getRequest(`/flightCabin/flightCabins`, searchDTO);
  }

  get(flightCabinId) {
    return this.getRequest(`/flightCabin/${flightCabinId}`, null);
  }

  findByField(matchData) {
    return this.getRequest(`/flightCabin?field=${matchData}`, null);
  }

  addFlightCabin(data) {
    return http.post("/flightCabin/addFlightCabin", data);
  }

  update(data) {
  	return http.post("/flightCabin/updateFlightCabin", data);
  }
  
  uploadImage(data,flightCabinId) {
  	return http.postForm("/flightCabin/uploadImage/"+flightCabinId, data);
  }




	postRequest(url, data) {
		return http.post(url, data);
      };

	getRequest(url, params) {
        return http.get(url, {
        	params: params
        });
    };

}

export default new FlightCabinService();
