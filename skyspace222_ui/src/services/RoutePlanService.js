import http from "../http-common"; 

class RoutePlanService {
  getAllRoutePlans(searchDTO) {
    console.log(searchDTO)
    return this.getRequest(`/routePlan/routePlans`, searchDTO);
  }

  get(routePlanId) {
    return this.getRequest(`/routePlan/${routePlanId}`, null);
  }

  findByField(matchData) {
    return this.getRequest(`/routePlan?field=${matchData}`, null);
  }

  addRoutePlan(data) {
    return http.post("/routePlan/addRoutePlan", data);
  }

  update(data) {
  	return http.post("/routePlan/updateRoutePlan", data);
  }
  
  uploadImage(data,routePlanId) {
  	return http.postForm("/routePlan/uploadImage/"+routePlanId, data);
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

export default new RoutePlanService();
