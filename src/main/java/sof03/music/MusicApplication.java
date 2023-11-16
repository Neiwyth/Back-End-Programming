package sof03.music;

import java.sql.Timestamp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sof03.music.domain.Band;
import sof03.music.domain.BandRepository;
import sof03.music.domain.Comment;
import sof03.music.domain.CommentRepository;
import sof03.music.domain.Song;
import sof03.music.domain.SongRepository;
import sof03.music.domain.User;
import sof03.music.domain.UserRepository;

@SpringBootApplication
public class MusicApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicApplication.class, args);
	}

	@Bean
	public CommandLineRunner Demo(BandRepository bandRepository, SongRepository songRepository,
			CommentRepository commentRepository, UserRepository userRepository) {

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

			Band band9 = new Band("Orden Ogan", 1996, "Germany", "Power Metal");
			bandRepository.save(band9);

			Band band10 = new Band("Broken By The Scream", 2016, "Japan", "Metal");
			bandRepository.save(band10);

			Band band11 = new Band("雪沉乐队", 2015, "China", "Folk Metal");
			bandRepository.save(band11);

			songRepository.save(new Song("Pain Remains I: Dancing Like Flames", 2022, "Pain Remains", band1,
					"spotify:track:227jOVNY1MrE5MkUcQRhsk",
					"https://www.youtube.com/watch?v=JglOS8TRFp4"));
			songRepository.save(new Song("Pain Remains II: After All I've Done, I'll Return Disappear", 2022,
					"Pain Remains", band1, "spotify:track:7IpJQhwrB4OYTYwOCiOxIs",
					"https://www.youtube.com/watch?v=JFJ5fF7cbE0"));
			songRepository.save(new Song("Pain Remains III: In a Sea of Fire", 2022, "Pain Remains", band1,
					"spotify:track:6wgKN7mUq1CvQBnQKzjeKt",
					"https://www.youtube.com/watch?v=BLptZzEXc68"));
			songRepository.save(new Song("Cursed to Die", 2022, "Pain Remains", band1,
					"spotify:track:1nqXQo7YXVQsUBflLauyzI",
					"https://www.youtube.com/watch?v=C7vk33ouN1A"));
			songRepository.save(new Song("Wrath", 2022, "Pain Remains", band1, "spotify:track:088lNGrrwYCmZ3Y21RZfNl",
					"https://www.youtube.com/watch?v=rv47EriDtAI"));
			songRepository.save(new Song("To the Hellfire", 2021, "...And I Return to Nothingness", band1,
					"spotify:track:5UpDvqyZnhdWY16L8HY6fw",
					"https://www.youtube.com/watch?v=R7WhvrALBoY&list"));
			songRepository.save(new Song("Immortal", 2019, "Immortal", band1, "spotify:track:6BlKRhk5hnrQ7HKrsPEesI",
					"https://www.youtube.com/watch?v=WwMnj0xTTlw"));
			songRepository.save(new Song("CADAVER", 2018, "CHANGE OF GENERATION", band2,
					"spotify:track:0v3TouyabYk2ISBhzq4qdY", "https://www.youtube.com/watch?v=-3W5kxNnwOU"));
			songRepository.save(new Song("REVADAC", 2018, "CHANGE OF GENERATION", band2,
					"spotify:track:1O7il5YDUAFBFoHhPjqHXG", "https://www.youtube.com/watch?v=FEk_Xp7zygs"));
			songRepository.save(new Song("Black Pentagram", 2018, "CHANGE OF GENERATION", band2,
					"spotify:track:29fKxzShkZ56Mf5xpO9vxe",
					"https://www.youtube.com/watch?v=V8i_QhOgsKw"));
			songRepository.save(new Song("imagimak", 2014, "Affected", band2, "spotify:track:7ud10eoJQCRXulTc80UrVr",
					"https://www.youtube.com/watch?v=F0D4rub3T6Q"));
			songRepository.save(new Song("Unending Sorceress", 2020, "Unfinished", band2,
					"spotify:track:22pXPe93huo02Oad3dKvco",
					"https://www.youtube.com/watch?v=PCv3s0T4bx0"));
			songRepository.save(new Song("六兆年と一夜物語", 2020, "軌跡 BEST COLLECTION II", band3,
					"spotify:track:1DlMfEEDOymsvLSGp9KKuO", "https://www.youtube.com/watch?v=T4RHuXd5pMg"));
			songRepository.save(new Song("天樂", 2020, "軌跡 BEST COLLECTION II", band3,
					"spotify:track:2rJDyc30BwA38G9E76o6yq", "https://www.youtube.com/watch?v=yQIWiS1Hm5M"));
			songRepository.save(new Song("吉原ラメント", 2020, "軌跡 BEST COLLECTION II", band3,
					"spotify:track:4coJIXVkae3oHxrvSuQm7U", "https://www.youtube.com/watch?v=-E9n-dIYMh8"));
			songRepository.save(new Song("細雪", 2018, "オトノエ", band3,
					"spotify:track:7unQtzPgtmZXSBzg0Aj8YT", "https://www.youtube.com/watch?v=UH-99ICQIKA"));
			songRepository.save(new Song("「儚くも美しいのは」", 2018, "オトノエ", band3,
					"spotify:track:54UBC79U4e6a0tudV8eHHI", "https://www.youtube.com/watch?v=bB0Te81lACM"));
			songRepository.save(new Song("Eclipse", 2020, "TOKYO SINGING", band3,
					"spotify:track:4hfBeZFQsl1S4yXFi1VuvL", "https://www.youtube.com/watch?v=yfao56Upmrk"));
			songRepository.save(new Song("宛名のない手紙", 2020, "TOKYO SINGING", band3,
					"spotify:track:5S5eCq2dKvvPqejcaU1dnR", "https://www.youtube.com/watch?v=LF3__bSgXbs"));
			songRepository.save(new Song("Ignite", 2020, "TOKYO SINGING", band3,
					"spotify:track:5BBSqc8eD7gyjGJNRm0F6Y", "https://www.youtube.com/watch?v=_uxpHq3inUA"));
			songRepository.save(new Song("日輪", 2020, "TOKYO SINGING", band3,
					"spotify:track:52b5eh9OATbT3GifqAey4k", "https://www.youtube.com/watch?v=wr7oHjMXpgs"));
			songRepository.save(new Song("ゲルニカ", 2020, "TOKYO SINGING", band3,
					"spotify:track:3CdUjqiOW9Muqe8kkrs3RD", "https://www.youtube.com/watch?v=kQvnKJlvHog"));
			songRepository.save(new Song("秋舞", 2018, "赤绫", band4,
					"spotify:track:4E6TQ1zAuRLiS4WqIJiv4k", "https://www.youtube.com/watch?v=8yIYA0n43sI"));
			songRepository.save(new Song("故卷", 2020, "宋陨星辰", band4,
					"spotify:track:6hildvmTHDvZKBz8TcOb0m", "https://www.youtube.com/watch?v=ThLnkVPPfbs"));
			songRepository.save(new Song("赤绫 (Remastered)", 2020, "宋陨星辰", band4,
					"spotify:track:2x3mdDesEluVXwobGgPjVB", "https://www.youtube.com/watch?v=geW-zaZzijk"));
			songRepository.save(new Song("古风铃", 2016, "破墨山谷", band4,
					"spotify:track:4Jteavl3QNaE58LyvnUjji", "https://www.youtube.com/watch?v=OHZKHKwKoxo"));
			songRepository.save(new Song("山谷涧", 2016, "破墨山谷", band4,
					"spotify:track:6mh0mrWUHHboZxwCa5CZ7E", "https://www.youtube.com/watch?v=PrjiFnelf_0"));
			songRepository.save(new Song("OIRAN", 2020, "OIRAN", band5,
					"spotify:track:65GsyWywSjH8jFNes15prd", "https://www.youtube.com/watch?v=CfDMZlr3AJM"));
			songRepository.save(new Song("SORAI", 2020, "雷霆 -RAITEI-", band5,
					"spotify:track:3i2soFCzqgmSD2FmK7vbQx", "https://www.youtube.com/watch?v=lh-dVLKP314"));
			songRepository.save(new Song("REVIVE", 2021, "REVIVE", band5,
					"spotify:track:4TmAlgqhKXdtwq6EB56pbX", "https://www.youtube.com/watch?v=zmRmVc4u18w"));
			songRepository.save(new Song("Pure Re-Recorded 2022", 2022, "Liberate The Unborn Inhumanity", band6,
					"spotify:track:2nLyeZy2v2vOanpYkBAf5q", "https://www.youtube.com/watch?v=avMOIcVctV4"));
			songRepository.save(new Song("The Ghost", 2017, "Embers of a Dying World", band6,
					"spotify:track:45y6JipFpEZFnAXCmzEiy5", "https://www.youtube.com/watch?v=fheTmD3n88Y"));
			songRepository.save(new Song("Master of the Dead", 2020, "Seven", band6,
					"spotify:track:4Fix2Qm2GGlzmZpKJCnnLd", "https://www.youtube.com/watch?v=69IDNUI9aw8"));
			songRepository.save(new Song("Pressure", 2005, "The Unborn", band6,
					"spotify:track:2BrJ8CIlRe5vJ7d1TfoNTH", "https://www.youtube.com/watch?v=tajAU7TwLpQ"));
			songRepository.save(new Song("I Am War", 2014, "Dawn of the 5th Era", band6,
					"spotify:track:55dIxgqiCeuKCqxa03hvif", "https://www.youtube.com/watch?v=oiaK6lCBO_Q"));
			songRepository.save(new Song("Victory Song", 2007, "Victory Songs", band7,
					"spotify:track:7gdTiRqj7gBMphz8GmwxYw", "https://www.youtube.com/watch?v=ueT3qH1GC5E"));
			songRepository.save(new Song("Goblins' Dance", 2001, "Ensiferum", band7,
					"spotify:track:2OBXIrRkIIRZXkXZBRFOiF", "https://www.youtube.com/watch?v=P8zUj6yhDM0"));
			songRepository.save(
					new Song("Shield Wall", 2019, "Berserker", band8,
							"spotify:track:73kaKlRGTP4tsN47JPxL2P", "https://www.youtube.com/watch?v=ojykx7jJv9E"));
			songRepository.save(
					new Song("First Kill", 2016, "Jomsviking", band8,
							"spotify:track:3hf590VY3jJzyV6BA7IqCb", "https://www.youtube.com/watch?v=qw5G6fF-wqQ"));
			songRepository.save(new Song("Cry of the Black Birds", 2006, "With Oden on Our Side", band8,
					"spotify:track:20YxWoyscYi0aIVXNlTpt5", "https://www.youtube.com/watch?v=_ZKdsAeNQis"));
			songRepository.save(new Song("Where is Your God?", 2008, "Twilight of the Thunder God", band8,
					"spotify:track:7sW6sWJxVBT65FPLHgRYUT", "https://www.youtube.com/watch?v=16CwvKD78aY"));
			songRepository
					.save(new Song("Twilight of the Thunder God", 2008, "Twilight of the Thunder God", band8,
							"spotify:track:5u3l2TONYacJgmRPQVaF9y", "https://www.youtube.com/watch?v=edBYB1VCV0k"));
			songRepository.save(new Song("The Hero", 2008, "Twilight of the Thunder God", band8,
					"spotify:track:3fTwPebsGs7q0rOrFkuwrF", "https://www.youtube.com/watch?v=I6SIHlK3LqQ"));
			songRepository.save(new Song("The Things We Believe In", 2012, "To The End", band9,
					"spotify:track:6G1r9YfIWGGnhg240AU1o1", "https://www.youtube.com/watch?v=Ir_BVxBz5do"));
			songRepository.save(new Song("Come With Me to the Other Side", 2017, "Gunmen", band9,
					"spotify:track:0H799tJ2Y3ZFBabhmKTXWf", "https://www.youtube.com/watch?v=oqGfr_stmxg"));
			songRepository
					.save(new Song("Absolution for Our Final days", 2022, "Absolution for Our Final Days", band9,
							"spotify:track:1rCXog1X6fMU5fRgNZZiFu", "https://www.youtube.com/watch?v=weeJxUCAdxA"));
			songRepository.save(new Song("Fields of Sorrow", 2017, "Gunmen", band9,
					"spotify:track:0zRzEkNEBpYls87sEnbBWG", "https://www.youtube.com/watch?v=7gagRay7VK8"));
			songRepository.save(new Song("サヨナラバースデー", 2018, "AN ALIEN'S PORTRAIT", band10,
					"spotify:track:5jX1xykBMcKuEuNx6PbE1O", "https://www.youtube.com/watch?v=Q8qOH-f6doM"));
			songRepository.save(new Song("陽炎", 2023, "Whitewater Park", band10,
					"spotify:track:6Tg1S2LTfcujvirvX2NS7R", "https://www.youtube.com/watch?v=c5f6drFwwSQ"));
			songRepository.save(new Song("迷僧", 2017, "乌木集", band11,
					"spotify:track:6d9CIafhHr1lTbUId89dSC", "https://www.youtube.com/watch?v=mEdnzYycESw"));
			songRepository.save(new Song("乌木", 2017, "乌木集", band11,
					"spotify:track:6JzcLZCj5TVmRgTKWZwY4l", "https://www.youtube.com/watch?v=I6xcaxN7Z3Q"));
			songRepository.save(new Song("脊封", 2021, "鹤行", band11,
					"spotify:track:3SquvYbRwFBZwAAC1CX0zp", "https://www.youtube.com/watch?v=FuQ9q4aqaOI"));

			User testUser = new User("testuser", "$2a$10$phULxnOptT1foiESO6mI8.NYDrN90l7mFt06jqvf8Z82IDZDXS.Lm",
					"USER");
			userRepository.save(testUser);

			User admin = new User("admin", "$2a$10$6zqXlFH.50lf/9gQkjaNIOnRBYTlT2gd/U3Oiwkq8Alx/dr0djzxu",
					"ADMIN");
			userRepository.save(admin);

			commentRepository.save(new Comment("Pain remains trilogy is my new favorite song",
					Timestamp.valueOf("2023-2-1 13:37:00"), band1, testUser));

		};
	}
}