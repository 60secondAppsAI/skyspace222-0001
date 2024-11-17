<template>
  <div class="content">
    <div class="row">
      <div class="col-12">
        <card class="card-plain">
          <!-- <template slot="header">
            <h4 class="card-title">Table on Plain Background</h4>
            <p class="category">Here is a subtitle for this table</p>
          </template>-->
          <div class="table-full-width text-left">
            <routePlan-table
            v-if="routePlans && routePlans.length > 0"
				:title="table1.title"
				:sub-title="table1.subTitle"
				:routePlans="routePlans"
				:totalElements="totalElements"
				:page="page"
				:columns="table1.columns"
 				@get-all-route-plans="getAllRoutePlans"
             >

            </routePlan-table>
          </div>
        </card>
      </div>

    </div>
  </div>
</template>
<script>
import { Card } from "@/components/Card";

import RoutePlanTable from "@/components/RoutePlanTable";
import RoutePlanService from "../services/RoutePlanService";

const tableColumns = [];
const tableData = [
];

export default {
  components: {
    Card,
    RoutePlanTable,
  },
  data() {
    return {
      routePlans: [],
	  totalElements: 0,
      page: 0,
      searchQuery: '',     
      table1: {
        title: "Simple Table",
        columns: [...tableColumns],
        data: [...tableData],
      },
    };
  },
  methods: {
    async getAllRoutePlans(sortBy='routePlanId',sortOrder='true',page="0",size="50") {
      try {
        try {
			const searchDTO = {
				sortBy: sortBy, 
				sortOrder: sortOrder, 
				searchQuery: this.searchQuery,
				page: page, 
				size: size
			};
	        let response = await RoutePlanService.getAllRoutePlans(searchDTO);
	        if (!response.data.empty) {
		        if (response.data.routePlans.length) {
					this.routePlans = response.data.routePlans;
				}
      			this.totalElements = response.data.totalElements;
      			this.page = response.data.page;
	        }
        } catch (error) {
          console.error("Error fetching routePlans:", error);
        }
        
      } catch (error) {
        console.error("Error fetching routePlan details:", error);
      }
    },
  },
  mounted() {
    this.getAllRoutePlans();
  },
  created() {
    this.$root.$on('searchQueryForRoutePlansChanged', (searchQuery) => {
    	this.searchQuery = searchQuery;
    	this.getAllRoutePlans();
    })
  }
};
</script>
<style></style>
