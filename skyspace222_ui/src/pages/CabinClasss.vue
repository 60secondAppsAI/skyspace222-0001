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
            <cabinClass-table
            v-if="cabinClasss && cabinClasss.length > 0"
				:title="table1.title"
				:sub-title="table1.subTitle"
				:cabinClasss="cabinClasss"
				:totalElements="totalElements"
				:page="page"
				:columns="table1.columns"
 				@get-all-cabin-classs="getAllCabinClasss"
             >

            </cabinClass-table>
          </div>
        </card>
      </div>

    </div>
  </div>
</template>
<script>
import { Card } from "@/components/Card";

import CabinClassTable from "@/components/CabinClassTable";
import CabinClassService from "../services/CabinClassService";

const tableColumns = [];
const tableData = [
];

export default {
  components: {
    Card,
    CabinClassTable,
  },
  data() {
    return {
      cabinClasss: [],
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
    async getAllCabinClasss(sortBy='cabinClassId',sortOrder='true',page="0",size="50") {
      try {
        try {
			const searchDTO = {
				sortBy: sortBy, 
				sortOrder: sortOrder, 
				searchQuery: this.searchQuery,
				page: page, 
				size: size
			};
	        let response = await CabinClassService.getAllCabinClasss(searchDTO);
	        if (!response.data.empty) {
		        if (response.data.cabinClasss.length) {
					this.cabinClasss = response.data.cabinClasss;
				}
      			this.totalElements = response.data.totalElements;
      			this.page = response.data.page;
	        }
        } catch (error) {
          console.error("Error fetching cabinClasss:", error);
        }
        
      } catch (error) {
        console.error("Error fetching cabinClass details:", error);
      }
    },
  },
  mounted() {
    this.getAllCabinClasss();
  },
  created() {
    this.$root.$on('searchQueryForCabinClasssChanged', (searchQuery) => {
    	this.searchQuery = searchQuery;
    	this.getAllCabinClasss();
    })
  }
};
</script>
<style></style>
