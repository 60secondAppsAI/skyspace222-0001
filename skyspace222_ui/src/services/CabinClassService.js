import http from "../http-common"; 

class CabinClassService {
  getAllCabinClasss(searchDTO) {
    console.log(searchDTO)
    return this.getRequest(`/cabinClass/cabinClasss`, searchDTO);
  }

  get(cabinClassId) {
    return this.getRequest(`/cabinClass/${cabinClassId}`, null);
  }

  findByField(matchData) {
    return this.getRequest(`/cabinClass?field=${matchData}`, null);
  }

  addCabinClass(data) {
    return http.post("/cabinClass/addCabinClass", data);
  }

  update(data) {
  	return http.post("/cabinClass/updateCabinClass", data);
  }
  
  uploadImage(data,cabinClassId) {
  	return http.postForm("/cabinClass/uploadImage/"+cabinClassId, data);
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

export default new CabinClassService();
