package jclee.study.books.modernjava.chap3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class SearchingTravelTest {

	@Test
	void search_VIETNAM(){
		SearchingTravel searchingTravel = new SearchingTravel();
		List<TravelInfo> travelInfos = searchingTravel.searchTravelInfo(SearchingTravel.COUNTRY_VIETNAM);

		for(TravelInfo travelInfo : travelInfos){
			System.out.println(travelInfo);
		}
	}

	@Test
	void searchTravelInfoByCountry() {
		SearchingTravel searchingTravel = new SearchingTravel();
		List<TravelInfo> travelInfos = searchingTravel.searchTravelInfoByCountry(SearchingTravel.COUNTRY_VIETNAM);

		for(TravelInfo travelInfo : travelInfos){
			System.out.println(travelInfo);
		}
	}

	@Test
	void searchTravelInfoByCity() {
		SearchingTravel searchingTravel = new SearchingTravel();
		List<TravelInfo> travelInfos = searchingTravel.searchTravelInfoByCity("cebu");

		for(TravelInfo travelInfo : travelInfos){
			System.out.println(travelInfo);
		}
	}

	@Test
	void searchTravelInfo_by_searchType() {
		SearchingTravel searchingTravel = new SearchingTravel();
		List<TravelInfo> travelInfos = searchingTravel.searchTravelInfo("city", "cebu");

		for(TravelInfo travelInfo : travelInfos){
			System.out.println(travelInfo);
		}
	}
}