import Vue from "vue";
import VueRouter from "vue-router";
import DefaultLayout from "@/layouts/DefaultLayout.vue";
import Flights from  '@/pages/Flights.vue';
import FlightDetail from  '@/pages/FlightDetail.vue';
import Airlines from  '@/pages/Airlines.vue';
import AirlineDetail from  '@/pages/AirlineDetail.vue';
import Airports from  '@/pages/Airports.vue';
import AirportDetail from  '@/pages/AirportDetail.vue';
import Passengers from  '@/pages/Passengers.vue';
import PassengerDetail from  '@/pages/PassengerDetail.vue';
import Tickets from  '@/pages/Tickets.vue';
import TicketDetail from  '@/pages/TicketDetail.vue';
import Bookings from  '@/pages/Bookings.vue';
import BookingDetail from  '@/pages/BookingDetail.vue';
import PaymentDetails from  '@/pages/PaymentDetails.vue';
import PaymentDetailDetail from  '@/pages/PaymentDetailDetail.vue';
import Luggages from  '@/pages/Luggages.vue';
import LuggageDetail from  '@/pages/LuggageDetail.vue';
import Seats from  '@/pages/Seats.vue';
import SeatDetail from  '@/pages/SeatDetail.vue';
import Pilots from  '@/pages/Pilots.vue';
import PilotDetail from  '@/pages/PilotDetail.vue';
import CrewMembers from  '@/pages/CrewMembers.vue';
import CrewMemberDetail from  '@/pages/CrewMemberDetail.vue';
import FlightCrews from  '@/pages/FlightCrews.vue';
import FlightCrewDetail from  '@/pages/FlightCrewDetail.vue';
import RoutePlans from  '@/pages/RoutePlans.vue';
import RoutePlanDetail from  '@/pages/RoutePlanDetail.vue';
import Meals from  '@/pages/Meals.vue';
import MealDetail from  '@/pages/MealDetail.vue';
import InFlightMeals from  '@/pages/InFlightMeals.vue';
import InFlightMealDetail from  '@/pages/InFlightMealDetail.vue';
import Gates from  '@/pages/Gates.vue';
import GateDetail from  '@/pages/GateDetail.vue';
import BoardingPasss from  '@/pages/BoardingPasss.vue';
import BoardingPassDetail from  '@/pages/BoardingPassDetail.vue';
import FrequentFlyers from  '@/pages/FrequentFlyers.vue';
import FrequentFlyerDetail from  '@/pages/FrequentFlyerDetail.vue';
import CabinClasss from  '@/pages/CabinClasss.vue';
import CabinClassDetail from  '@/pages/CabinClassDetail.vue';
import FlightCabins from  '@/pages/FlightCabins.vue';
import FlightCabinDetail from  '@/pages/FlightCabinDetail.vue';

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: () => import("../views/HomeView.vue"),
			redirect: '/flights',
																				  },
  {
    path: "/pricing",
    name: "PricingView",
    component: () => import("../views/PricingView.vue"),
  },
  {
    path: "/arts-gallery",
    name: "ArtsGalleryView",
    component: () => import("../views/ArtsGalleryView.vue"),
  },
  {
    path: "/checkout/:id",
    name: "CheckoutView",
    component: () => import("../views/CheckoutView.vue"),
  },
  {
    path: "/stripe-checkout",
    name: "StripeCheckoutView",
    component: () => import("../views/StripeCheckoutView.vue"),
  },
	{
		path: '/flights',
		name: 'Flights',
		layout: DefaultLayout,
		component: Flights,
	},
	{
	    path: '/flight/:flightId', 
	    name: 'FlightDetail',
		layout: DefaultLayout,
	    component: FlightDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/airlines',
		name: 'Airlines',
		layout: DefaultLayout,
		component: Airlines,
	},
	{
	    path: '/airline/:airlineId', 
	    name: 'AirlineDetail',
		layout: DefaultLayout,
	    component: AirlineDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/airports',
		name: 'Airports',
		layout: DefaultLayout,
		component: Airports,
	},
	{
	    path: '/airport/:airportId', 
	    name: 'AirportDetail',
		layout: DefaultLayout,
	    component: AirportDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/passengers',
		name: 'Passengers',
		layout: DefaultLayout,
		component: Passengers,
	},
	{
	    path: '/passenger/:passengerId', 
	    name: 'PassengerDetail',
		layout: DefaultLayout,
	    component: PassengerDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/tickets',
		name: 'Tickets',
		layout: DefaultLayout,
		component: Tickets,
	},
	{
	    path: '/ticket/:ticketId', 
	    name: 'TicketDetail',
		layout: DefaultLayout,
	    component: TicketDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/bookings',
		name: 'Bookings',
		layout: DefaultLayout,
		component: Bookings,
	},
	{
	    path: '/booking/:bookingId', 
	    name: 'BookingDetail',
		layout: DefaultLayout,
	    component: BookingDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/paymentDetails',
		name: 'PaymentDetails',
		layout: DefaultLayout,
		component: PaymentDetails,
	},
	{
	    path: '/paymentDetail/:paymentDetailId', 
	    name: 'PaymentDetailDetail',
		layout: DefaultLayout,
	    component: PaymentDetailDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/luggages',
		name: 'Luggages',
		layout: DefaultLayout,
		component: Luggages,
	},
	{
	    path: '/luggage/:luggageId', 
	    name: 'LuggageDetail',
		layout: DefaultLayout,
	    component: LuggageDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/seats',
		name: 'Seats',
		layout: DefaultLayout,
		component: Seats,
	},
	{
	    path: '/seat/:seatId', 
	    name: 'SeatDetail',
		layout: DefaultLayout,
	    component: SeatDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/pilots',
		name: 'Pilots',
		layout: DefaultLayout,
		component: Pilots,
	},
	{
	    path: '/pilot/:pilotId', 
	    name: 'PilotDetail',
		layout: DefaultLayout,
	    component: PilotDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/crewMembers',
		name: 'CrewMembers',
		layout: DefaultLayout,
		component: CrewMembers,
	},
	{
	    path: '/crewMember/:crewMemberId', 
	    name: 'CrewMemberDetail',
		layout: DefaultLayout,
	    component: CrewMemberDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/flightCrews',
		name: 'FlightCrews',
		layout: DefaultLayout,
		component: FlightCrews,
	},
	{
	    path: '/flightCrew/:flightCrewId', 
	    name: 'FlightCrewDetail',
		layout: DefaultLayout,
	    component: FlightCrewDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/routePlans',
		name: 'RoutePlans',
		layout: DefaultLayout,
		component: RoutePlans,
	},
	{
	    path: '/routePlan/:routePlanId', 
	    name: 'RoutePlanDetail',
		layout: DefaultLayout,
	    component: RoutePlanDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/meals',
		name: 'Meals',
		layout: DefaultLayout,
		component: Meals,
	},
	{
	    path: '/meal/:mealId', 
	    name: 'MealDetail',
		layout: DefaultLayout,
	    component: MealDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/inFlightMeals',
		name: 'InFlightMeals',
		layout: DefaultLayout,
		component: InFlightMeals,
	},
	{
	    path: '/inFlightMeal/:inFlightMealId', 
	    name: 'InFlightMealDetail',
		layout: DefaultLayout,
	    component: InFlightMealDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/gates',
		name: 'Gates',
		layout: DefaultLayout,
		component: Gates,
	},
	{
	    path: '/gate/:gateId', 
	    name: 'GateDetail',
		layout: DefaultLayout,
	    component: GateDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/boardingPasss',
		name: 'BoardingPasss',
		layout: DefaultLayout,
		component: BoardingPasss,
	},
	{
	    path: '/boardingPass/:boardingPassId', 
	    name: 'BoardingPassDetail',
		layout: DefaultLayout,
	    component: BoardingPassDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/frequentFlyers',
		name: 'FrequentFlyers',
		layout: DefaultLayout,
		component: FrequentFlyers,
	},
	{
	    path: '/frequentFlyer/:frequentFlyerId', 
	    name: 'FrequentFlyerDetail',
		layout: DefaultLayout,
	    component: FrequentFlyerDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/cabinClasss',
		name: 'CabinClasss',
		layout: DefaultLayout,
		component: CabinClasss,
	},
	{
	    path: '/cabinClass/:cabinClassId', 
	    name: 'CabinClassDetail',
		layout: DefaultLayout,
	    component: CabinClassDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/flightCabins',
		name: 'FlightCabins',
		layout: DefaultLayout,
		component: FlightCabins,
	},
	{
	    path: '/flightCabin/:flightCabinId', 
	    name: 'FlightCabinDetail',
		layout: DefaultLayout,
	    component: FlightCabinDetail,
	    props: true // Pass route params as props to the component
  	},
];

const router = new VueRouter({
  mode: "hash",
  base: process.env.BASE_URL,
  routes,
});

export default router;
