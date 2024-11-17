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
            <flightCabin-table
            v-if="flightCabins && flightCabins.length > 0"
				:title="table1.title"
				:sub-title="table1.subTitle"
				:flightCabins="flightCabins"
				:totalElements="totalElements"
				:page="page"
				:columns="table1.columns"
 				@get-all-flight-cabins="getAllFlightCabins"
             >

            </flightCabin-table>
          </div>
        </card>
      </div>

    </div>
  </div>
</template>
<script>
import { Card } from "@/components/Card";

import FlightCabinTable from "@/components/FlightCabinTable";
import FlightCabinService from "../services/FlightCabinService";

const tableColumns = [];
const tableData = [
];

export default {
  components: {
    Card,
    FlightCabinTable,
  },
  data() {
    return {
      flightCabins: [],
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
    async getAllFlightCabins(sortBy='flightCabinId',sortOrder='true',page="0",size="50") {
      try {
        try {
			const searchDTO = {
				sortBy: sortBy, 
				sortOrder: sortOrder, 
				searchQuery: this.searchQuery,
				page: page, 
				size: size
			};
	        let response = await FlightCabinService.getAllFlightCabins(searchDTO);
	        if (!response.data.empty) {
		        if (response.data.flightCabins.length) {
					this.flightCabins = response.data.flightCabins;
				}
      			this.totalElements = response.data.totalElements;
      			this.page = response.data.page;
	        }
        } catch (error) {
          console.error("Error fetching flightCabins:", error);
        }
        
      } catch (error) {
        console.error("Error fetching flightCabin details:", error);
      }
    },
  },
  mounted() {
    this.getAllFlightCabins();
  },
  created() {
    this.$root.$on('searchQueryForFlightCabinsChanged', (searchQuery) => {
    	this.searchQuery = searchQuery;
    	this.getAllFlightCabins();
    })
  }
};
</script>
<style></style>
