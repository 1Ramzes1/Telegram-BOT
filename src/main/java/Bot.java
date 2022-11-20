import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Bot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "Log_in_off_first_bot";
    }
    // Цой CQACAgIAAxkBAAMJY3qOYYIXk3qqbdLuUKH2QqX5H-QAApokAALXi9BL3P4swf-6Lr8rBA
    // По барам CQACAgIAAxkBAAMLY3qPApun80dPh71TxIM1iJTNaQYAAqYkAALXi9BLhXFaKSUgpiQrBA
    // Солнце в монако CQACAgIAAxkBAAMNY3qPLby5_nSTFVY9uZ2jhlixLbMAAhshAAL5gdlL679NM5WKxIQrBA
    @Override
    public String getBotToken() {
        return "5607819384:AAEQDlXslkX6w2cIjOrvAoDyjARoHFlpw-g";
    }

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(new KeyboardButton("ANNA ASTI"));
        keyboardRow.add(new KeyboardButton("Цой жив"));

        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(new KeyboardButton("Солнце в монако"));

        List<KeyboardRow> list = new ArrayList<>();
        list.add(keyboardRow);
        list.add(keyboardRow1);


        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(list);
        sendMessage.setText(update.getMessage().getText());
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        SendAudio sendAudio = new SendAudio();
        sendAudio.setChatId(update.getMessage().getChatId().toString());
        InputFile inputFile = new InputFile();

        switch (update.getMessage().getText()){
            case "Солнце в монако":
                inputFile.setMedia("CQACAgIAAxkBAAMNY3qPLby5_nSTFVY9uZ2jhlixLbMAAhshAAL5gdlL679NM5WKxIQrBA");
                break;
            case "Цой жив":
                inputFile.setMedia("CQACAgIAAxkBAAMJY3qOYYIXk3qqbdLuUKH2QqX5H-QAApokAALXi9BL3P4swf-6Lr8rBA");
                break;
            case "ANNA ASTI":
                inputFile.setMedia("CQACAgIAAxkBAAMLY3qPApun80dPh71TxIM1iJTNaQYAAqYkAALXi9BLhXFaKSUgpiQrBA");
                break;
        }
        sendAudio.setAudio(inputFile);
        try {
            execute(sendAudio);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        /*String name = update.getMessage().getText();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        sendMessage.setText("Здарова чепуха");
        String id = String.valueOf(update.getMessage().getAudio().getFileId());
        sendMessage.setText("Вот твой id лови "+id);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
        SendAudio sendAudio = new SendAudio();
        sendAudio.setChatId(update.getMessage().getChatId().toString());
        sendAudio.setAudio(new InputFile("CQACAgIAAxkBAAMLY3qPApun80dPh71TxIM1iJTNaQYAAqYkAALXi9BLhXFaKSUgpiQrBA"));
        sendAudio.setCaption("ANNA-ASTI По барам");

        try {
            execute(sendAudio);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }*/

    }
}