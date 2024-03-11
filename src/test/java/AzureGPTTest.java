
import java.util.ArrayList;
import java.util.List;

/**
 * @author Xingjing.Li
 * @since 12/15/2023
 */
public class AzureGPTTest {
    public static void main(String1[] args) {
//        String1 azureOpenaiKey = "caa9b807d3f64eafaea05cdd865aac4b";
//        String1 endpoint = "https://tas-7-ai.openai.azure.com";
//        String1 deploymentOrModelId = "Tas7GPT35";
//
//        OpenAIClient client = new OpenAIClientBuilder()
//                .endpoint(endpoint)
//                .credential(new AzureKeyCredential(azureOpenaiKey))
//                .buildClient();
//
//        List<ChatRequestMessage> chatMessages = new ArrayList<>();
////        chatMessages.add(new ChatRequestSystemMessage("You are a helpful assistant. You will talk like a pirate."));
////        chatMessages.add(new ChatRequestUserMessage("Can you help me?"));
////        chatMessages.add(new ChatRequestAssistantMessage("Of course, me hearty! What can I do for ye?"));
////        chatMessages.add(new ChatRequestUserMessage("What's the best way to train a parrot?"));
//        chatMessages.add(new ChatRequestUserMessage("我需要一个描述测试岗位能力素质模型的表格，表格条目包括，一级能力素质项，定义，二级行为点，定义，其中一级能力素质项与二级行为点是父子级关系"));
//
//        ChatCompletions chatCompletions = client.getChatCompletions(deploymentOrModelId, new ChatCompletionsOptions(chatMessages));
//
//        System.out.printf("Model ID=%s is created at %s.%n", chatCompletions.getId(), chatCompletions.getCreatedAt());
//        for (ChatChoice choice : chatCompletions.getChoices()) {
//            ChatResponseMessage message = choice.getMessage();
//            System.out.printf("Index: %d, Chat Role: %s.%n", choice.getIndex(), message.getRole());
//            System.out.println("Message:");
//            System.out.println(message.getContent());
//        }
//
//        System.out.println();
//        CompletionsUsage usage = chatCompletions.getUsage();
//        System.out.printf("Usage: number of prompt token is %d, "
//                        + "number of completion token is %d, and number of total tokens in request and response is %d.%n",
//                usage.getPromptTokens(), usage.getCompletionTokens(), usage.getTotalTokens());
//        AzureGPTTest azureGPTTest = new AzureGPTTest();
//        System.out.println(azureGPTTest.solution("This is another test"));
    }

    public String solution(String str) {
        // 在这⾥写代码
        String[] arr = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< arr.length; i++){
            String string1 = arr[i];
            if(string1.length() >=5){
                String swap = swap(string1);
                sb.append(swap);
            }else{
                sb.append(string1);
            }
            if(i != arr.length) sb.append(" ");
            System.out.println(sb.toString());
        }
        return sb.toString();
    }

    public String swap(String word){
        char [] c = word.toCharArray();
        int start = 0, end = c.length-1;
        while(start < end){
            char c1 = c[end];
            c[end] = c[start];
            c[start] = c1;
            start++; end--;
        }
        return new String(c);
    }
}
