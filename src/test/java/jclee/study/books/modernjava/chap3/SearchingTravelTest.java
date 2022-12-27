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

}