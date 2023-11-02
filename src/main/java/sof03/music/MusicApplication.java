package sof03.music;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sof03.music.domain.Band;
import sof03.music.domain.BandRepository;
import sof03.music.domain.Song;
import sof03.music.domain.SongRepository;

@SpringBootApplication
public class MusicApplication {

	// private static final Logger log =
	// LoggerFactory.getLogger(MusicApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MusicApplication.class, args);
	}

	@Bean
	public CommandLineRunner Demo(BandRepository bandRepository, SongRepository songRepository) {

		return (args) -> {

			Band band1 = new Band("Lorna Shore", 2009, "USA", "Deathcore");
			bandRepository.save(band1);

			Band band2 = new Band("Unlucky Morpheus", 2008, "Japan", "Power Metal");
			bandRepository.save(band2);

			Band band3 = new Band("Wagakki Band", 2013, "Japna", "Metal");
			bandRepository.save(band3);

			Band band4 = new Band("小雨", 2005, "China", "Folk Metal");
			bandRepository.save(band4);

			Band band5 = new Band("NEMOPHILA", 2019, "Japan", "Metal");
			bandRepository.save(band5);

			Band band6 = new Band("Mors Principum Est", 1999, "Finland", "Melodic Death Metal");
			bandRepository.save(band6);

			Band band7 = new Band("Ensiferum", 1995, "Finland", "Folk Metal");
			bandRepository.save(band7);

			Band band8 = new Band("Amon Amarth", 1992, "Sweden", "Melodic Death Metal");
			bandRepository.save(band8);

			songRepository.save(new Song("Pain Remains I: Dancing Like Flames", 2022, "Pain Remains", band1));
			songRepository.save(new Song("Pain Remains II: After All I've Done, I'll Return Disappear", 2022,
					"Pain Remains", band1));
			songRepository.save(new Song("Pain Remains III: In a Sea of Fire", 2022, "Pain Remains", band1));
			songRepository.save(new Song("Welcome Back, O' Sleeping Dreamer", 2022, "Pain Remains", band1));
			songRepository.save(new Song("Cursed to Die", 2022, "Pain Remains", band1));
			songRepository.save(new Song("Wrath", 2022, "Pain Remains", band1));
			songRepository.save(new Song("To the Hellfire", 2021, "...And I Return to Nothingness", band1));
			songRepository.save(new Song("Immortal", 2019, "Immortal", band1));

		};
	}
}