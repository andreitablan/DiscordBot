package botConfiguration;

import com.sun.syndication.io.FeedException;
import dataBase.AnswersRepository;
import drawImage.DrawGraph;
import drawImage.NodesManager;
import exceptions.QuestionNotFoundException;
import graphAlgorithms.BreadthFirstSearch;
import graphAlgorithms.ConnectedGraph;
import graphAlgorithms.DepthFirstSearch;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import rssReader.RssReader;
import timekeeper.TimekeeperMilliseconds;
import timekeeper.TimekeeperSeconds;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.IOException;

public class DiscordBot extends ListenerAdapter {

    private final TimekeeperSeconds timekeeperSeconds;
    private final TimekeeperMilliseconds timekeeperMilliseconds;
    private final Thread threadTimerSeconds;
    private final Thread threadTimerMilliseconds;

    /**
     * Starts two threads for counting the running time.
     */
    public DiscordBot() {

        this.timekeeperSeconds = new TimekeeperSeconds();
        this.threadTimerSeconds = new Thread(timekeeperSeconds);
        threadTimerSeconds.setDaemon(true);

        this.timekeeperMilliseconds = new TimekeeperMilliseconds();
        this.threadTimerMilliseconds = new Thread(timekeeperMilliseconds);
        threadTimerMilliseconds.setDaemon(true);

        threadTimerSeconds.start();
        threadTimerMilliseconds.start();

    }

    /**
     * Handles the messages from the users, given on the discord server.
     *
     * @param event The event that is received when a user sends a message.
     */
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message message = event.getMessage();
        if (message.getContentRaw().equals("!help")) {
            MessageChannel channel = event.getChannel();
            String output = "You asked for help! \n" +
                    "You can use the following commands: \n" +
                    "1. rss:<url> \n" +
                    "2. !<question>\n" +
                    "For this command we have the answer to the following questions: isomorphic, digraph, k-clique, " +
                    "bipartite graph, planar graph, connected graph, connected component, tree, bridge, Eulerian, " +
                    "Hamiltonian.\n" +
                    "3. dfs: <number of nodes> <starting node> <edges>\n" +
                    "4. bfs: <number of nodes> <starting node> <edges>\n" +
                    "5. connected: <number of nodes> <edges>\n" +
                    "6. draw: <number of nodes> <edges>\n" +
                    "7. !seconds \n" +
                    "8. !milliseconds \n" +
                    "9. !help";
            channel.sendMessage(output).queue();
        } else if (message.getContentRaw().equals("!seconds")) {
            MessageChannel channel = event.getChannel();
            channel.sendMessage(timekeeperSeconds.getTimeElapsed()).queue();
        } else if (message.getContentRaw().equals("!milliseconds")) {
            MessageChannel channel = event.getChannel();
            channel.sendMessage(timekeeperMilliseconds.getTimeElapsed()).queue();
        } else if (message.getContentRaw().charAt(0) == '!') {
            String msgString = message.getContentRaw().substring(1);
            MessageChannel channel = event.getChannel();
            AnswersRepository answersRepository = new AnswersRepository();
            try {
                channel.sendMessage(answersRepository.findByQuestion(msgString)).queue();
            } catch (Exception exception) {
                try {
                    throw new QuestionNotFoundException(msgString, channel);
                } catch (QuestionNotFoundException exception1) {
                    exception1.printStackTrace();
                }
            }
        } else if (message.getContentRaw().startsWith("rss:")) {
            String link = message.getContentRaw().substring(4);
            try {
                RssReader rssReader = new RssReader();
                String answer = rssReader.readRss(link);
                MessageChannel channel = event.getChannel();
                channel.sendMessage(answer).queue();
            } catch (FeedException | IOException e) {
                throw new RuntimeException(e);
            }
        } else if (message.getContentRaw().startsWith("dfs:")) {
            String input = message.getContentRaw().substring(5);
            DepthFirstSearch depthFirstSearch = new DepthFirstSearch(input);
            MessageChannel channel = event.getChannel();
            channel.sendMessage(depthFirstSearch.getNodes()).queue();
        } else if (message.getContentRaw().startsWith("bfs:")) {
            String input = message.getContentRaw().substring(5);
            BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(input);
            MessageChannel channel = event.getChannel();
            channel.sendMessage(breadthFirstSearch.getNodes()).queue();
        } else if (message.getContentRaw().startsWith("connected:")) {
            String input = message.getContentRaw().substring(11);
            ConnectedGraph connectedGraph = new ConnectedGraph();
            MessageChannel channel = event.getChannel();
            channel.sendMessage(connectedGraph.checkConnected(input)).queue();
        } else if (message.getContentRaw().startsWith("draw:")) {
            String input = message.getContentRaw().substring(6);
            NodesManager nodesManager = new NodesManager();
            nodesManager.manageNodes(input);
            MessageChannel channel = event.getChannel();
            try {
                DrawGraph drawGraph = new DrawGraph(nodesManager.getNodeList());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            channel.sendFile(new File("C:\\Users\\andre\\Desktop\\graph.png")).queue();
        }
    }

    /**
     * Connects with the discord server token and runs the bot.
     *
     * @throws LoginException
     * @throws InterruptedException
     */
    public void run() throws LoginException, InterruptedException {

        JDA bot = JDABuilder.createLight("OTc5Mjg4NTI3MTI2NzkwMTU1.Guv5IA.Has0wrUnW60u0UrhiW1je4W9TbMZMZFGw59zBQ",
                GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES).addEventListeners(new DiscordBot())
                .setActivity(Activity.playing("Scrie: !help")).build();
        bot.awaitReady();
    }


}


