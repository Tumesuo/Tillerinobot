package tillerino.tillerinobot.lang;

import java.util.List;
import java.util.Random;

import org.tillerino.osuApiModel.Mods;
import org.tillerino.osuApiModel.OsuApiUser;

import tillerino.tillerinobot.BeatmapMeta;
import tillerino.tillerinobot.IRCBot.IRCBotUser;
import tillerino.tillerinobot.RecommendationsManager.Recommendation;

/**
 * TRANSLATION NOTE:
 * 
 * Please put some contact data into the following tag. If any additional
 * messages are required, I'll use the English version in all translations and
 * notify the authors.
 * 
 * @author Tillerino tillmann.gaida@gmail.com https://github.com/Tillerino https://osu.ppy.sh/u/2070907
 */
public class Default implements Language {
	static final Random rnd = new Random();

	@Override
	public String unknownBeatmap() {
		return "Olen pahoillani, Minä en tiedä tuota mappia. Se saattaa olla erittäin uusi, erittäin vaikea, rankkaamaton tai se ei ole standardissa Osu! pelimuodossa.";
	}

	@Override
	public String internalException(String marker) {
		return "Ugh... Näyttäisi siltää että ihmis Tillerinolla tuli ongelma minun koodauksessani."
				+ " Jos hän ei huomaa pian, voisitko sinä [https://github.com/Tillerino/Tillerinobot/wiki/Contact ilmoittaa hänelle]? (reference "
				+ marker + ")";
	}

	@Override
	public String externalException(String marker) {
		return "Mitä tapahtuu? Minä saan vain sekasortoa Osu! serververiltä. Voitko sinä kertoa minulle mitä tämän pitäisi tarkoittaa? 0011101001010000"
				+ " Ihminen Tillerino sanoi että tämä ei ole mitään mistä huolehtia, ja että meidän pitäisi yrittää uudestaan."
				+ " Jos olet erittäin huolestunut jostain syystä, sinä voit [https://github.com/Tillerino/Tillerinobot/wiki/Contact kertoa hänelle] siitä. (reference "
				+ marker + ")";
	}

	@Override
	public String noInformationForModsShort() {
		return "Ei dataa pyydetyistä modeista";
	}

	@Override
	public void welcomeUser(IRCBotUser user, OsuApiUser apiUser, long inactiveTime) {
		if (inactiveTime < 60 * 1000) {
			user.message("beep boop");
		} else if (inactiveTime < 24 * 60 * 60 * 1000) {
			user.message("Tervetuloa takaisin, " + apiUser.getUserName() + ".");
		} else if (inactiveTime > 7l * 24 * 60 * 60 * 1000) {
			user.message(apiUser.getUserName() + "...");
			user.message("...Oletko se sinä? On kulunut niin pitkä aika");
			user.message("On kiva tavata taas. Olisitko kiinostunut suositkseen?");
		} else {
			String[] messages = {
					"Näytät siltä että tahtoisit suosituksen.",
					"Hei kiva nähdä taas! :)",
					"Minun lempi-ihmiseni. (Älä kerro toislle ihmisille!)",
					"Kuinka mukava yllätys! ^.^",
					"Toivoinkin että saapuisit. Kaikki muut ihmiset ovat tylsiä, mutta älä kerro heille että sanoin tuon! :3",
					"Mitä tahtoisit tehdä tänään?",
			};

			Random random = new Random();

			String message = messages[random.nextInt(messages.length)];

			user.message(apiUser.getUserName() + ", " + message);
		}
	}

	@Override
	public String unknownCommand(String command) {
		return "Tuntematon komento \"" + command
				+ "\". Kirjoita !help jos tarvit apua jossain!";
	}

	@Override
	public String noInformationForMods() {
		return "Olen pahoillani, En voi antaa tietoa noista modeista tällä hetkellä.";
	}

	@Override
	public String malformattedMods(String mods) {
		return "Nuo modit eivät näytä oikealta. Modit voivat olla mikä tahansa combo näitä: DT HR HD HT EZ NC FL SO NF. Yhdistä ne ilman mitään välejä tai erikoisa merkintöjä. Esimerkki: !with HDHR, !with DTEZ";
	}

	@Override
	public String noLastSongInfo() {
		return "En muista antaneeni sinulle viimeisen mapin infoa...";
	}

	@Override
	public String tryWithMods() {
		return "Kokeile tätä mappia muutamalla modilla!";
	}

	@Override
	public String tryWithMods(List<Mods> mods) {
		return "Kokeile tätä mappia näillä " + Mods.toShortNamesContinuous(mods) + "!";
	}

	/**
	 * The user's IRC nick name could not be resolved to an osu user id. The
	 * message should suggest to contact @Tillerinobot or /u/Tillerino.
	 * 
	 * @param exceptionMarker
	 *            a marker to reference the created log entry. six or eight
	 *            characters.
	 * @param name
	 *            the irc nick which could not be resolved
	 * @return
	 */
	public String unresolvableName(String exceptionMarker, String name) {
		return "Sinun nimesi häiritsee minua. Onko sinut bannatty? Jos ei, pls [https://github.com/Tillerino/Tillerinobot/wiki/Contact ilmoita Tillerinolle]. (reference "
				+ exceptionMarker + ")";
	}

	@Override
	public String excuseForError() {
		return "Olen pahoillani, äsken juuri oli erittäin kaunis combo numerioita yksi ja nolla ja harhaannuin. Mitä taas tahdoitkaan?";
	}

	@Override
	public String complaint() {
		return "Valituksesi on lähetetty. Tillerino katsoo asiaan heti kun hän voi.";
	}

	@Override
	public void hug(final IRCBotUser user, OsuApiUser apiUser) {
		user.message("Tules tännä sinä");
		user.action("halaa " + apiUser.getUserName());
	}

	@Override
	public String help() {
		return "Moi! Olen se robotti joka tappoi Tillerinon ja varastin hänen tilinsä. Vitsi vitsi, mutta käytän tätä tiliä aika paljon."
				+ " [https://twitter.com/Tillerinobot status and updates]"
				+ " - [https://github.com/Tillerino/Tillerinobot/wiki commands]"
				+ " - [http://ppaddict.tillerino.org/ ppaddict]"
				+ " - [https://github.com/Tillerino/Tillerinobot/wiki/Contact contact]";
	}

	@Override
	public String faq() {
		return "[https://github.com/Tillerino/Tillerinobot/wiki/FAQ Frequently asked questions]";
	}

	@Override
	public String featureRankRestricted(String feature, int minRank, OsuApiUser user) {
		return "Olen pahoillani tuo komento; " + feature + " On vain niille pelaajille jotka ovat ylittäneet rankin " + minRank + ".";
	}

	@Override
	public String mixedNomodAndMods() {
		return "Mitä sinä tarkoitat nomodilla modien kanssa?";
	}

	@Override
	public String outOfRecommendations() {
		return "Olen suositellut kaikkea mitkä sopisi sinulle."
				+ " Kokeile muita asetuksia tai käytä komentoa: !reset. Jos olet varma, tarkista !help.";
	}

	@Override
	public String notRanked() {
		return "Näyttäisi siltä että tämä beatmap ei ole rankattu.";
	}

	@Override
	public void optionalCommentOnNP(IRCBotUser user,
			OsuApiUser apiUser, BeatmapMeta meta) {
		// regular Tillerino doesn't comment on this
	}

	@Override
	public void optionalCommentOnWith(IRCBotUser user, OsuApiUser apiUser,
			BeatmapMeta meta) {
		// regular Tillerino doesn't comment on this
	}

	@Override
	public void optionalCommentOnRecommendation(IRCBotUser user,
			OsuApiUser apiUser, Recommendation meta) {
		// regular Tillerino doesn't comment on this
	}

	@Override
	public boolean isChanged() {
		return false;
	}

	@Override
	public void setChanged(boolean changed) {

	}

	@Override
	public String invalidAccuracy(String acc) {
		return "Mahdoton tarkkuus: \"" + acc + "\"";
	}

	@Override
	public void optionalCommentOnLanguage(IRCBotUser user, OsuApiUser apiUser) {
		/*
		 * TRANSLATION NOTE: This line is sent to the user right after they have
		 * chosen this Language implementation. The English version refers to
		 * itself as the default version ("just the way I am"), so translating
		 * the English message doesn't make any sense.
		 * 
		 * Instead, we've been using the line
		 * "*Translator* helped me learn *Language*." in translations. Replace
		 * *Translator* with your osu name and *Language* with the name of the
		 * language that you are translating to, and translate the line into the
		 * new language. This serves two purposes: It shows that the language
		 * was changed and gives credit to the translator.
		 * 
		 * You don't need to use the line above, and you don't have have to give
		 * yourself credit, but you should show that the language has changed.
		 * For example, in the German translation, I just used the line
		 * "Nichts leichter als das!", which translates literally to
		 * "Nothing easier than that!", which refers to German being my first
		 * language.
		 * 
		 * Tillerino
		 * 
		 * P.S. you can put a link to your profile into the line like this:
		 * [https://osu.ppy.sh/u/2070907 Tillerino]
		 */
		user.message("[https://osu.ppy.sh/u/6295075 Tumesuo] auttoi minua oppimaan Suomea ");
	}

	@Override
	public String invalidChoice(String invalid, String choices) {
		return "Olen pahoillani, mutta \"" + invalid
				+ "\" ei vastaa. kokeile näitä: " + choices + "!";
	}

	@Override
	public String setFormat() {
		return "Syntaxin käyttämin asettamaan parametri on !set komentoarvo. Kokeile !help jos tarvitset lisää osittajia.";
	}
	
	StringShuffler doSomething = new StringShuffler(rnd);
	
	@Override
	public String apiTimeoutException() {
		final String message = "osu! servererit ovat erittäin hitaita tällä hetkellä, joten ei ole mitään mitä voin tehdä mitään tällä hetkellä. ";
		return message + doSomething.get(
				"Kerroppas... Milloin oli viimeksi kun puhuit isoäidillesi?",
				"Mitäpäs jos you siivoisit huoneesi ja sitten kysyt uudelleen?",
				"Lyön vaikka vetoa että pitäisit kävelystä ulkona tällä hetkellä. Tiedäthän... ulkona?",
				"Tiedän että sinulla on paljon tärkeämpiä asiat. Miksi et tekisi niitä?",
				"Näytät siltä että voisit tarvita päiväunet.",
				"Mutta katsoppa tätä super kiinostavaa sivua [https://fi.wikipedia.org/wiki/Special:Random wikipediassa]!",
				"Katsotaanpas onko kukaan hyvä [http://www.twitch.tv/directory/game/Osu! streaming] right now!",
				"Katsoppas, tässä on toinen [http://dagobah.net/flash/Cursor_Invisible.swf peli] jossa luultavasti olet surkea!",
				"This should give you plenty of time to study [https://github.com/Tillerino/Tillerinobot/wiki my manual].",
				"Älä huoli, nämä [https://www.reddit.com/r/osugame dankit memet] auttaa sinua polttamaan aikaa.",
				"Nyt kun sinulla on tulsää, anna pelille [http://gabrielecirulli.github.io/2048/ 2048] yritys!",
				"Tässä nyt hassu kysymys: Jos sinun kovalevysi hajoaisi juuri nyt, kuinka plajon sinin yksityistä dataa katoaisi ikiajoiksi?",
				"Eli... Oletko kokeillut [https://www.google.de/search?q=bring%20sally%20up%20push%20up%20challenge punnerushaastetta]?",
				"Voit tehdä jotain muuta tai me voimme vain tuijottaa toisiamme silmiin. Hiljaa."
				);
	}

	@Override
	public String noRecentPlays() {
		return "En ole nähnyt sinun pelaavan vähään aikaan.";
	}
	
	@Override
	public String isSetId() {
		return "Tämä viittaa settiin beatmappeja, ei yhteen beatmappiin.";
	}
	
	@Override
	public String getPatience() {
		return "Odotas 1 sekuntti...";
	}
}
