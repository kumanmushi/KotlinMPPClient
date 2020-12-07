import SwiftUI
import shared
import SDWebImageSwiftUI

final class ViewModel: ObservableObject {
    let dogsSDK = DogsKMMSDK()
    
    @Published var dogs: [Dog] = []

    func fetchDogs() {
        self.dogsSDK.fetch { (result, error) in
            if let images = result?.images {
                self.dogs = images.map { Dog(image: $0)}
            }
            
            if let error = error {
                print(error)
            }
        }
    }
}

struct Dog: Identifiable {
    var id = UUID()
    var image: String
}

struct ContentView: View {
    @ObservedObject private var viewModel = ViewModel()
    
    var body: some View {
        List(viewModel.dogs) { dog in
            WebImage(url: URL(string: dog.image))
                .resizable()
                .indicator(.activity)
                .scaledToFit()
        }.onAppear(perform: {
            self.viewModel.fetchDogs()
        })
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
